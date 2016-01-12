package com.allinfnt.idc.modules.act.service;

import java.util.Map;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.cmd.NeedsActiveTaskCmd;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;

public class TaskCommitCmd extends NeedsActiveTaskCmd<Void>{

	private static final long serialVersionUID = 1L;

	/**
	 * 目标任务定义ID
	 */
	private String toTaskKey;
	
	/**
	 * 参数
	 */
	protected Map<String ,Object> variables;
	
	/**
	 * 回退
	 */
	protected String type;
	
	public TaskCommitCmd(String _taskId, String _toTaskKey,String _type,Map<String ,Object> _variables) {
		super(_taskId);
		this.toTaskKey = _toTaskKey;
		this.type = _type; 
		this.variables = _variables;
	}

	@Override
	protected Void execute(CommandContext commandContext, TaskEntity task) {
		if(variables != null) task.setExecutionVariables(variables);
		ExecutionEntity execution = task.getExecution();
		String procDefId = execution.getProcessDefinitionId();
		//获取服务         
        RepositoryServiceImpl repositoryService =  (RepositoryServiceImpl)execution.getEngineServices().getRepositoryService();   
        //获取流程定义的所有节点  
        ProcessDefinitionImpl processDefinitionImpl =  (ProcessDefinitionImpl)repositoryService.getDeployedProcessDefinition(procDefId);  
        //获取需要提交的节点  
        ActivityImpl toActivityImpl = processDefinitionImpl.findActivity(this.toTaskKey);  
           
        if(toActivityImpl == null ){   
            throw new ActivitiException(this.toTaskKey+" to ActivityImpl is null!");  
        }else{  
            task.fireEvent("complete");
            Context.getCommandContext().getTaskEntityManager().deleteTask(task,this.type, false);   
            execution.removeTask(task);
            execution.executeActivity(toActivityImpl);  
        }
		return null;
	}

}
