package com.allinfnt.idc.modules.act.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.activiti.engine.TaskService;
import org.activiti.engine.impl.HistoricActivityInstanceQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.cmd.GetDeploymentProcessDefinitionCmd;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.HistoricActivityInstanceEntity;
import org.activiti.engine.impl.persistence.entity.HistoricTaskInstanceEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

//import com.allinfnt.oa.common.utils.SpringContextHolder;
//import com.allinfnt.oa.modules.sys.dao.ActHiActinstDao;
//import com.allinfnt.oa.modules.sys.service.DelegateApplyService;
//import com.allinfnt.oa.modules.sys.service.workflow.graph.ActivitiHistoryGraphBuilder;
//import com.allinfnt.oa.modules.sys.service.workflow.graph.Edge;
//import com.allinfnt.oa.modules.sys.service.workflow.graph.Graph;
//import com.allinfnt.oa.modules.sys.service.workflow.graph.Node;

/**
 * 撤销
 * @author liujx
 * @version 2014-12-04
 */
public class WithdrawTaskCmd implements Command<Integer> {

	@Override
	public Integer execute(CommandContext commandContext) {
		// TODO Auto-generated method stub
		return null;
	}
//    private static Logger logger = LoggerFactory.getLogger(WithdrawTaskCmd.class);
//    
//    private String historyTaskId;
//    
//    @Autowired
//	protected TaskService taskService;
//    
////    @Autowired
////	private ActHiActinstDao actHiActinstDao;
////    @Autowired
////    private DelegateApplyService delegateApplyService;
//
//    /**
//     * 这个historyTaskId是已经完成的一个任务的id.
//     */
//    public WithdrawTaskCmd(String historyTaskId) {
//        this.historyTaskId = historyTaskId;
//    }
//
//    /**
//     * 撤销流程.
//     * 
//     * @return 0-撤销成功 1-流程结束 2-下一结点已经通过,不能撤销
//     */
//    public Integer execute(CommandContext commandContext) {
//        // 获得历史任务
//        HistoricTaskInstanceEntity historicTaskInstanceEntity = Context
//                .getCommandContext().getHistoricTaskInstanceEntityManager()
//                .findHistoricTaskInstanceById(historyTaskId);
//
//        // 获得历史节点
//        HistoricActivityInstanceEntity historicActivityInstanceEntity = getHistoricActivityInstanceEntity(historyTaskId);
//
//        Graph graph = new ActivitiHistoryGraphBuilder(historicTaskInstanceEntity.getProcessInstanceId()).build();
//        Node node = graph.findById(historicActivityInstanceEntity.getId());
//
//        if (!checkCouldWithdraw(node)) {
//            logger.info("cannot withdraw {}", historyTaskId);
//
//            return 2;
//        }
//        
//        historicTaskInstanceEntity.getTaskLocalVariables();
//        ExecutionEntity executionEntity = Context.getCommandContext().getExecutionEntityManager().findExecutionById(historicTaskInstanceEntity.getExecutionId());
//        if(executionEntity==null){
//        	return 4;
//        }
//
//        // 删除所有活动中的task
//        this.deleteActiveTasks(historicTaskInstanceEntity.getProcessInstanceId());
//
//        // 获得期望撤销的节点后面的所有节点历史
//        List<String> historyNodeIds = new ArrayList<String>();
//        this.collectNodes(node, historyNodeIds);
//        this.deleteHistoryActivities(historyNodeIds);
//        // 恢复期望撤销的任务和历史
//        String result = this.processHistoryTask(historicTaskInstanceEntity,historicActivityInstanceEntity);
//        
//        
//
//        logger.info("activiti is withdraw {}",historicTaskInstanceEntity.getName());
//
//        return 0;
//    }
//
//    /**
//     * 
//     * @param historyTaskId
//     * @return
//     */
//    public HistoricActivityInstanceEntity getHistoricActivityInstanceEntity(String historyTaskId) {
//    	
//    	if (actHiActinstDao == null) {
//    		actHiActinstDao = SpringContextHolder.getBean("actHiActinstDao");
//		}
//    	
//        logger.info("historyTaskId : {}", historyTaskId);
//        String historicActivityInstanceId = actHiActinstDao.getHisInstanceId(historyTaskId);
//        logger.info("historicActivityInstanceId : {}",historicActivityInstanceId);
//
//        HistoricActivityInstanceQueryImpl historicActivityInstanceQueryImpl = new HistoricActivityInstanceQueryImpl();
//        historicActivityInstanceQueryImpl.activityInstanceId(historicActivityInstanceId);
//
//        HistoricActivityInstanceEntity historicActivityInstanceEntity = (HistoricActivityInstanceEntity) Context
//                .getCommandContext()
//                .getHistoricActivityInstanceEntityManager()
//                .findHistoricActivityInstancesByQueryCriteria(historicActivityInstanceQueryImpl, new Page(0, 1))
//                .get(0);
//
//        return historicActivityInstanceEntity;
//    }
//
//    public boolean checkCouldWithdraw(Node node) {
//    	
//    	if(node!=null){
//    		//如果是catchEvent，也应该可以撤销，到时候再说
//            for (Edge edge : node.getOutgoingEdges()) {
//                Node dest = edge.getDest();
//                String type = dest.getType();
//
//                if ("userTask".equals(type)) {
//                    if (!dest.isActive()) {
//                        boolean isSkip = isSkipActivity(dest.getId());
//
//                        if (isSkip) {
//                            return checkCouldWithdraw(dest);
//                        } else {
//                            logger.info("cannot withdraw, " + type + "("
//                                    + dest.getName() + ") is complete.");
//
//                            return false;
//                        }
//                    }
//                } else if (type.endsWith("Gateway")) {
//                    return checkCouldWithdraw(dest);
//                } else {
//                    logger.info("cannot withdraw, " + type + "(" + dest.getName()
//                            + ") is complete.");
//
//                    return false;
//                }
//            }
//
//            return true;
//    	}
//    	return false;
//    }
//
//    /**
//     * 删除未完成任务.
//     */
//    public void deleteActiveTasks(String processInstanceId) {
//        Context.getCommandContext().getTaskEntityManager()
//                .deleteTasksByProcessInstanceId(processInstanceId, null, true);
//    }
//
//    public void collectNodes(Node node, List<String> historyNodeIds) {
//        logger.info("node : {}, {}, {}", node.getId(), node.getType(),node.getName());
//
//        for (Edge edge : node.getOutgoingEdges()) {
//            logger.info("edge : {}", edge.getName());
//
//            Node dest = edge.getDest();
//            historyNodeIds.add(dest.getId());
//            this.collectNodes(dest, historyNodeIds);
//        }
//    }
//
//    /**
//     * 删除历史节点.
//     */
//    public void deleteHistoryActivities(List<String> historyNodeIds) {
//    	
//    	if (actHiActinstDao == null) {
//    		actHiActinstDao = SpringContextHolder.getBean("actHiActinstDao");
//		}
//    	
//        logger.info("historyNodeIds : {}", historyNodeIds);
//
//        for(String id : historyNodeIds){
//            String taskId = actHiActinstDao.getHisTaskId(id);
//
//            if (taskId != null) {
//                Context.getCommandContext().getHistoricTaskInstanceEntityManager().deleteHistoricTaskInstanceById(taskId);
//            }
//            actHiActinstDao.deleteHiActinst(id);
//        }
//    }
//
//	public String processHistoryTask(
//            HistoricTaskInstanceEntity historicTaskInstanceEntity,
//            HistoricActivityInstanceEntity historicActivityInstanceEntity) {
//    	if (delegateApplyService == null) {
//    		delegateApplyService = SpringContextHolder.getBean("delegateApplyService");
//		}
//    	if (taskService == null) {
//    		taskService = SpringContextHolder.getBean("taskService");
//		}
//        historicTaskInstanceEntity.setEndTime(null);
//        historicTaskInstanceEntity.setDurationInMillis(null);
//        historicActivityInstanceEntity.setEndTime(null);
//        historicActivityInstanceEntity.setDurationInMillis(null);
//
//        TaskEntity task = TaskEntity.create(new Date());
//        task.setProcessDefinitionId(historicTaskInstanceEntity
//                .getProcessDefinitionId());
//        task.setId(historicTaskInstanceEntity.getId());
//        task.setAssigneeWithoutCascade(historicTaskInstanceEntity.getAssignee());
//        task.setParentTaskIdWithoutCascade(historicTaskInstanceEntity
//                .getParentTaskId());
//        task.setNameWithoutCascade(historicTaskInstanceEntity.getName());
//        task.setTaskDefinitionKey(historicTaskInstanceEntity
//                .getTaskDefinitionKey());
//        task.setExecutionId(historicTaskInstanceEntity.getExecutionId());
//        task.setPriority(historicTaskInstanceEntity.getPriority());
//        task.setProcessInstanceId(historicTaskInstanceEntity
//                .getProcessInstanceId());
//        task.setDescriptionWithoutCascade(historicTaskInstanceEntity
//                .getDescription());
//        ExecutionEntity executionEntity = Context.getCommandContext().getExecutionEntityManager().findExecutionById(historicTaskInstanceEntity.getExecutionId());
//        if(executionEntity==null){
////        	executionEntity = Context.getCommandContext().getExecutionEntityManager().findExecutionById(historicTaskInstanceEntity.getProcessInstanceId());
////        	executionEntity.setActivity(getActivity(historicActivityInstanceEntity));
////        	executionEntity.inactivate();
////        	ExecutionEntity newExecution = executionEntity.createExecution();
////        	taskService.saveTask(task);
////        	task.setExecutionId(newExecution.getId());
//        	return "4";
//        }else{
//        	Context.getCommandContext().getTaskEntityManager().insert(task);
//            executionEntity.setActivity(getActivity(historicActivityInstanceEntity));
//        }
//		return historyTaskId;
//        
//        
//        
//    }
//
//    public ActivityImpl getActivity(
//            HistoricActivityInstanceEntity historicActivityInstanceEntity) {
//        ProcessDefinitionEntity processDefinitionEntity = new GetDeploymentProcessDefinitionCmd(
//                historicActivityInstanceEntity.getProcessDefinitionId())
//                .execute(Context.getCommandContext());
//
//        return processDefinitionEntity
//                .findActivity(historicActivityInstanceEntity.getActivityId());
//    }
//
//    public boolean isSkipActivity(String historyActivityId) {
//    	if (actHiActinstDao == null) {
//    		actHiActinstDao = SpringContextHolder.getBean("actHiActinstDao");
//		}
//        String historyTaskId = actHiActinstDao.getHisTaskId(historyActivityId);
//
//        HistoricTaskInstanceEntity historicTaskInstanceEntity = Context
//                .getCommandContext().getHistoricTaskInstanceEntityManager()
//                .findHistoricTaskInstanceById(historyTaskId);
//        String deleteReason = historicTaskInstanceEntity.getDeleteReason();
//
//        return "跳过".equals(deleteReason);
//    }
}
