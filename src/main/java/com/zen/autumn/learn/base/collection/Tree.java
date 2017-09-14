package com.zen.autumn.learn.base.collection;

public class Tree {
	
	private Node root;
	
	public Node find(int key){
		Node current = root;
		while(current.key != key){
			
			if(key<current.key){
				current = current.leftChild;
			}else{
				current = current.rightChild;
			}
			
			if(current == null){
				return null;
			}
		}
		return current;
		
		
	}
	
	public void insert(int key,double value){
		
		Node newNode = new Node();
		newNode.key = key;
		newNode.value = value;
		
		if(root == null){
			root = newNode;
		}
		else{
			
			Node current = root;
			Node parent;
			while(true){
				parent = current;
				
				if(key<current.key){
					
					current = current.leftChild;
					if(current == null){
						
						parent.leftChild = newNode;
						return;
						
					}					
				}else{
					current = current.rightChild;
					if(current == null){
						parent.rightChild  = newNode;
						return;
					}
					
				}				
			}				
		}
	}
	
	
	
	private void inOrder(Node root){
		
		if(root != null){
			inOrder(root.leftChild);
			System.out.println(root.value);
			inOrder(root.rightChild);
		}
	}
	
	private void preOrder(Node root){
		
		if(root != null){
			System.err.println(root.value);
			preOrder(root.leftChild);
			preOrder(root.rightChild);
			
			
		}
		
		
	}
	
	
	public Node min(Node root){
		
		Node current = root;
		while(current.leftChild != null){
			current = current.leftChild;
		}
		return current;
		
		
		
	}
	
	public void delete(int key){
		
	}
	
	
	public void OrderTest(){
		Tree tree = new Tree();
		tree.insert(4, 4.000);
		tree.insert(2, 2.000);
		tree.insert(3, 3.000);
		inOrder(tree.root);
		preOrder(tree.root);
		
	}
	
	
	
	public static class Node{
		
		int key;
		double value;
		Node leftChild;
		Node rightChild;
		
		
	}
	

}
