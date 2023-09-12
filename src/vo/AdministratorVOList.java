package vo;

import java.util.ArrayList;
import java.util.List;

public class AdministratorVOList {
	
	private List<Integer> emp_no;
//	private String emp_name;
//	private String emp_job;
	private List<Integer> jg_no;
	
	/*
	 * AdministratorVO Ŭ������ emp_no �ʵ尡 null�� 
	 * �ʱ�ȭ�Ǿ� �ֱ� ������ getEmp_no() �޼��带 ȣ���ϸ�
	 * NullPointerException�� �߻��մϴ�. 
	 * ���� emp_no �ʵ带 �ʱ�ȭ�ϴ� �ڵ带 �߰��ؾ� �մϴ�.
	 * �Ʒ��� getEmp_no() �޼��忡�� �ʵ带 �ʱ�ȭ�ϴ� ����Դϴ�.
	 * �̷��� �ڵ带 �����ϸ� getEmp_no() �޼��尡 ȣ��� �� 
	 * emp_no �ʵ尡 null�� ��쿡�� �ʱ�ȭ�� ����ǰ�, 
	 * �̹� �ʱ�ȭ�� ��쿡�� ������ ����Ʈ�� ��ȯ�մϴ�.
	 */
  	public List<Integer> getEmp_no() {
  		if(emp_no == null) {
  			emp_no = new ArrayList<Integer>();
  		}
  		return emp_no;
  	}
  	
	public void setEmp_no(List<Integer> emp_no) {
		
		this.emp_no = emp_no;
	}
	
	public List<Integer> getJg_no() {
		if(jg_no == null) {
			jg_no = new ArrayList<Integer>();
		}
		return jg_no;
	}
	
//	public void setJg_no(List<Integer> jg_no) {
//		this.jg_no = jg_no;
//	}
//
//	public String getEmp_name() {
//		return emp_name;
//	}
//
//	public void setEmp_name(String emp_name) {
//		this.emp_name = emp_name;
//	}
//
//	public String getEmp_job() {
//		return emp_job;
//	}
//
//	public void setEmp_job(String emp_job) {
//		this.emp_job = emp_job;
//	}
	
	

}
