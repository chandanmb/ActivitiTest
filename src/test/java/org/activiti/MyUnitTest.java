package org.activiti;
import static org.junit.Assert.assertNotNull;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Rule;
import org.junit.Test;

public class MyUnitTest {
	
	@Rule
	public ActivitiRule activitiRule = new ActivitiRule();
	
	@Test
	@org.activiti.engine.test.Deployment(resources = {"org/activiti/test/my-process.bpmn20.xml"})
	public void test() {
		try {
			
			 String honeywell="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
					 "<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"Definitions_1\" targetNamespace=\"http://bpmn.io/schema/bpmn\">\n" +
					 "  <bpmn:process id=\"Process_1\" isExecutable=\"true\">\n" +
					 "    <bpmn:startEvent id=\"StartEvent_1\">\n" +
					 "      <bpmn:outgoing>SequenceFlow_08i2mct</bpmn:outgoing>\n" +
					 "    </bpmn:startEvent>\n" +
					 "    <bpmn:task id=\"Task_0dai62i\" name=\"Task 1 for User to Approve\">\n" +
					 "      <bpmn:incoming>SequenceFlow_08i2mct</bpmn:incoming>\n" +
					 "      <bpmn:outgoing>SequenceFlow_016tavy</bpmn:outgoing>\n" +
					 "    </bpmn:task>\n" +
					 "    <bpmn:sequenceFlow id=\"SequenceFlow_08i2mct\" sourceRef=\"StartEvent_1\" targetRef=\"Task_0dai62i\" />\n" +
					 "    <bpmn:endEvent id=\"EndEvent_16nl57m\">\n" +
					 "      <bpmn:incoming>SequenceFlow_016tavy</bpmn:incoming>\n" +
					 "    </bpmn:endEvent>\n" +
					 "    <bpmn:sequenceFlow id=\"SequenceFlow_016tavy\" sourceRef=\"Task_0dai62i\" targetRef=\"EndEvent_16nl57m\" />\n" +
					 "  </bpmn:process>\n" +
					 "  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n" +
					 "    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_1\">\n" +
					 "      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_1\">\n" +
					 "        <dc:Bounds x=\"308\" y=\"297\" width=\"36\" height=\"36\" />\n" +
					 "        <bpmndi:BPMNLabel>\n" +
					 "          <dc:Bounds x=\"281\" y=\"333\" width=\"90\" height=\"20\" />\n" +
					 "        </bpmndi:BPMNLabel>\n" +
					 "      </bpmndi:BPMNShape>\n" +
					 "      <bpmndi:BPMNShape id=\"Task_0dai62i_di\" bpmnElement=\"Task_0dai62i\">\n" +
					 "        <dc:Bounds x=\"413\" y=\"275\" width=\"100\" height=\"80\" />\n" +
					 "      </bpmndi:BPMNShape>\n" +
					 "      <bpmndi:BPMNEdge id=\"SequenceFlow_08i2mct_di\" bpmnElement=\"SequenceFlow_08i2mct\">\n" +
					 "        <di:waypoint xsi:type=\"dc:Point\" x=\"344\" y=\"315\" />\n" +
					 "        <di:waypoint xsi:type=\"dc:Point\" x=\"413\" y=\"315\" />\n" +
					 "        <bpmndi:BPMNLabel>\n" +
					 "          <dc:Bounds x=\"333.5\" y=\"290\" width=\"90\" height=\"20\" />\n" +
					 "        </bpmndi:BPMNLabel>\n" +
					 "      </bpmndi:BPMNEdge>\n" +
					 "      <bpmndi:BPMNShape id=\"EndEvent_16nl57m_di\" bpmnElement=\"EndEvent_16nl57m\">\n" +
					 "        <dc:Bounds x=\"578\" y=\"297\" width=\"36\" height=\"36\" />\n" +
					 "        <bpmndi:BPMNLabel>\n" +
					 "          <dc:Bounds x=\"551\" y=\"333\" width=\"90\" height=\"20\" />\n" +
					 "        </bpmndi:BPMNLabel>\n" +
					 "      </bpmndi:BPMNShape>\n" +
					 "      <bpmndi:BPMNEdge id=\"SequenceFlow_016tavy_di\" bpmnElement=\"SequenceFlow_016tavy\">\n" +
					 "        <di:waypoint xsi:type=\"dc:Point\" x=\"513\" y=\"315\" />\n" +
					 "        <di:waypoint xsi:type=\"dc:Point\" x=\"578\" y=\"315\" />\n" +
					 "        <bpmndi:BPMNLabel>\n" +
					 "          <dc:Bounds x=\"500.5\" y=\"290\" width=\"90\" height=\"20\" />\n" +
					 "        </bpmndi:BPMNLabel>\n" +
					 "      </bpmndi:BPMNEdge>\n" +
					 "    </bpmndi:BPMNPlane>\n" +
					 "  </bpmndi:BPMNDiagram>\n" +
					 "</bpmn:definitions>";


			
			
			RepositoryService repositoryService = activitiRule.getRepositoryService();
			
			Deployment deployment = repositoryService.createDeployment().addString("Process_1", honeywell).deploy();
			
			
			System.out.println("Deployment::::::::"+deployment);
			
			ProcessInstance processInstance = activitiRule.getRuntimeService().startProcessInstanceByKey("Process_1");
			
			System.out.println("processInstance::::::::::::::"+processInstance.getId());
			assertNotNull(processInstance);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
