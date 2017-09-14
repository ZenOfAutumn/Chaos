package com.zen.autumn.learn.base.xml.dom;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.common.collect.Lists;


class Property{
	private String nameCN;
	
	private String functionName;
	
	
	
	public String getNameCN() {
		return nameCN;
	}



	public void setNameCN(String nameCN) {
		this.nameCN = nameCN;
	}



	public String getFunctionName() {
		return functionName;
	}



	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	


	public Property(String nameCN, String functionName) {
		super();
		this.nameCN = nameCN;
		this.functionName = functionName;
	}



	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Property){
			Property other = (Property) obj;
			return nameCN.equals(other.getNameCN())&&this.functionName.equals(other.getFunctionName());
			
		}
		return false;
		
	}
	
	
	@Override
	public String toString() {
		return this.nameCN+":"+this.functionName;
	}
	
}

public class XMLDomParser {

	public static final String FILE_PATH = "";
	
	static List<Property> pro = Lists.newArrayList();
	
	
	

	static void parseXML(String filePath, String fatherNodeName, String sonNodeName) {

		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringComments(true);

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			File file = new File(filePath);
			Document doc = builder.parse(file);
			Element rootElement = doc.getDocumentElement();
			System.out.println(rootElement.getNodeName());
			Element node1 = (Element)rootElement.getElementsByTagName("groups").item(0);
			System.out.println(node1.getNodeName());
			NodeList node2 = node1.getElementsByTagName("group");
			
			
			for(int i= 0;i<node2.getLength();i++){
				Element now = (Element)node2.item(i);
				Element sons = (Element)now.getElementsByTagName("groupName").item(0);
				Element son = (Element)now.getElementsByTagName("functionName").item(0);
				Property pp = new Property(sons.getTextContent(), son.getTextContent());
				if(!pro.contains(pp)){
					pro.add(pp);
				}		
				
			}
			
			
			

		} catch (ParserConfigurationException e) {
		} catch (SAXException e) {
		} catch (IOException e1) {
		}

	}

	public static void main(String[] args) {
		parseXML("condition_config_accountlist_refactor.xml", "groupName", "functionName");
		parseXML("indicator_config_accountlist.xml", "groupName", "functionName");
		parseXML("indicator_config_accountlist_for_ztc.xml", "groupName", "functionName");
		
		for(Property p : pro){
			System.out.println(p);
		}


	}

}
