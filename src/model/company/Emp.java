package model.company;

public class Emp {
	private int empno;
	private String ename;
	private int sal;
	private Dept deptno;
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public Dept getDeptno() {
		return deptno;
	}
	public void setDeptno(Dept deptno) {
		this.deptno = deptno;
	}
	
}
