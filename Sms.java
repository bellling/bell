package com.briup.ch13;

import java.util.Scanner;
/**
	ҵ����
	��ʦ��Ϣ����ϵͳ
	������ʦ��Ϣ���浽��ʦ���󣬽�ʦ���󱣴������飨���ܳ־û����棩
*/
public class Tms {
	private Teacher[] Teas;	//�洢��ʦ���������
	private int index;		//��¼�����н�ʦ�ĸ���

	public Tms(){
		this.Teas = new Teacher[3];
		this.index = 0;
	}
	/**
	  ��ӽ�ʦ��Ϣ
	  @author zhangsan
	  @param Ҫ��ӵĽ�ʦ
	*/
	public void save(Teacher stu){
		//����ʦ�ĸ������������������ɵķ�Χ��ʱ����Ҫ�����������չ
		if(index >= Teas.length){
			Teacher[] demo = new Teacher[Teas.length+3];
			System.arraycopy(Teas,0,demo,0,index);
			Teas = demo;
		}
		Teas[index++] = stu;
	}
	/**
	  ��ѯ���н�ʦ
	  @author  lisi
	  @return �������н�ʦ������
	*/
	public Teacher[] findAll(){
		Teacher[] demo = new Teacher[index];
		System.arraycopy(Teas,0,demo,0,index);
		return demo;
	}
	/**
	  ͨ��id��ѯ��ʦ
	  @author wangwu
	  @param id
	  @return
		null	û�ҵ�
		stu		��ѯ���Ľ�ʦ
	*/
	public Teacher findById(long id){
		//1,ͨ��id��λ��
		int num = findIndexById(id);
		//2,�Ѹ�λ���ϵĶ��󷵻�
		return num==-1?null:Teas[num];
	}
	/**
	  ͨ��id��������
	  @author licy
	  @param id
	  @return 
		-1		�Ҳ���
		������	�ý�ʦ�������е�λ��
	*/
	public int findIndexById(long id){
		int num = -1;
		for(int i=0;i<index;i++){
			if(Teas[i].getId() == id){
				num = i;
				break;
			}
		}
		return num;
	}


	/**
	  ͨ��idɾ����ʦ
	  @author zhaoliu
	  @param id

	  Teas = {
		{1001,terry,12},
		{1003,terry,12},
		{1004,terry,12},
		null,
		null,
		null
	  }
	  index = 3;
	  id = 1002
	  num = 1
	  Teas[1] = Teas[1+1]
	  Teas[2] = Teas[2+1]

	*/
	public void deleteById(long id){
		int num = findIndexById(id);
		for(int i=num;i<index-1;i++){
			Teas[i] = Teas[i+1];
		}
		Teas[--index] = null;
	}
	/**
	  ���½�ʦ��Ϣ,id�����޸�
	  @author guoqi
	  @paran ��ʦ����
	  1001:terry:12
	  1001:TERRY:13
	*/
	public void update(Teacher newStu){
		for(int i=0;i<index;i++){
			if(Teas[i].getId() == newStu.getId()){
				Teas[i].setName(newStu.getName());
				Teas[i].setAge(newStu.getAge());
			}
		}
	}

	/**
		�˵�
		@auhor
	*/
	public void menu(){
		System.out.println("***********��ʦ��Ϣ����ϵͳ***********");
		System.out.println("*1. ��ѯ���н�ʦ��Ϣ");
		System.out.println("*2. ¼���ʦ��Ϣ");
		System.out.println("*3. ɾ����ʦ��Ϣ");
		System.out.println("*4. �鿴��ʦ��Ϣ");
		System.out.println("*5. ���Ľ�ʦ��Ϣ");
		System.out.println("*help. ����");
		System.out.println("*exit. �˳�");
		System.out.println("**************************************");
	}

	public static void main(String[] args){
		Tms Tms = new Tms();	
		Scanner sc = new Scanner(System.in);
		Tms.menu();
		while(true){
			System.out.print("�����빦�ܱ�ţ�");
			String option = sc.nextLine();
			switch(option){
				case "1":{//��ѯ���н�ʦ��Ϣ
					System.out.println("���������н�ʦ����Ϣ��");
					//���÷�����ѯ���н�ʦ��Ϣ
					Teacher[] arr = Tms.findAll();
					//����
					for(Teacher stu : arr){
						System.out.println(stu);
					}
					System.out.println("�ܼ� "+Tms.index+"��");
					break;
				}
				case "2":{//¼���ʦ��Ϣ
					while(true){
						System.out.println("�������ʦ��Ϣ��id#name#age���������롾break���������˵�");
						String Teastr = sc.nextLine();
						if(Teastr.equals("break")){
							break;
						}
						String[] stuArr = Teastr.split("#");
						//���û���������д���
						long id = Long.parseLong(stuArr[0]);
						String name = stuArr[1];
						int age = Integer.parseInt(stuArr[2]);
						//��װ����
						Teacher stu = new Teacher(id,name,age);
						//���ñ��淽��
						Tms.save(stu);
						System.out.println("¼��ɹ���");
						
					}
					break;
				}
				case "3":{//ɾ����ʦ��Ϣ
					while(true){
						System.out.println("������Ҫɾ����ʦ�ġ�id���������롾break��������Ŀ¼");
						String idStr = sc.nextLine();
						if(idStr.equals("break")){
							break;
						}
						//���ַ���idת��Ϊ������
						long id = Long.parseLong(idStr);
						Teacher stu = Tms.findById(id);
						if(stu == null){
							System.out.println("�ý�ʦ�����ڣ�");
							continue;
						}
						Tms.deleteById(id);
						System.out.println("ɾ���ɹ���");
					}

					break;
				}
				case "4":{//�鿴��ʦ��Ϣ
					while(true){
						System.out.println("������Ҫ���ҽ�ʦ�ġ�id���������롾break��������Ŀ¼");
						String idStr = sc.nextLine();
						if(idStr.equals("break")){
							break;
						}
						//���ַ���idת��Ϊ������
						long id = Long.parseLong(idStr);
						Teacher stu = Tms.findById(id);
						if(stu == null){
							System.out.println("�ý�ʦ�����ڣ�");
							continue;
						}
						System.out.println(stu);
					}
					break;
				}
				case "5":{
					while(true){
						System.out.println("������Ҫ�޸Ľ�ʦ�ġ�id���������롾break��������Ŀ¼");
						String idStr = sc.nextLine();
						if(idStr.equals("break")){
							break;
						}
						//���ַ���idת��Ϊ������
						long id = Long.parseLong(idStr);
						Teacher stu = Tms.findById(id);
						if(stu == null){
							System.out.println("��Ҫ�޸ĵĽ�ʦ��Ϣ�����ڣ�");
							continue;
						}

						System.out.println("��Ҫ�޸ĵĽ�ʦ��ϢΪ��"+stu);
						System.out.println("������ý�ʦ������Ϣ��name#age��");
						String Teastr = sc.nextLine();
						String[] stuArr = Teastr.split("#");
						String name = stuArr[0];
						int age = Integer.parseInt(stuArr[1]);
						Teacher newStu = new Teacher(id,name,age);
						Tms.update(newStu);
						System.out.println("�޸ĳɹ�");
					}
					break;
				}
				case "exit":{
					System.out.println("bye bye!��ӭ�ٴ�ʹ�ã�");
					System.exit(0);
				}
				case "help":{
					Tms.menu();
					break;
				}
				default:
					System.out.println("��������");
			}
		}
	}
}