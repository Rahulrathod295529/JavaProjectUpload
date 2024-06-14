package com.tka.OrganizationSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

@Repository
public class MainDao {
	@Autowired
	SessionFactory factory;

	public String addCountry(Country c) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		session = factory.openSession();
		tx = session.beginTransaction();

		session.persist(c);
		tx.commit();
		msg = "Country is added";

		// try catch block use if backend code feaching problem
		// then it roll back data from database
		try {

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;

	}

	public String updateRecord(int id, Country c) {
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();

			Country country = session.get(Country.class, id);

			country.setCname(c.getCname());
			session.merge(country);
			tx.commit();
			msg = "Country is updated";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;

	}

	public String deleteRecord(int id) {

		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {

			session = factory.openSession();
			tx = session.beginTransaction();

			Country country = session.get(Country.class, id);
			session.remove(country);
			session.getTransaction().commit();
			session.close();
			return "Record Delete Successfully";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	public List<Country> getAllRecords() {
		Session session = null;
		Transaction tx = null;

		String hqlQuery = "from Country";

		session = factory.openSession();
		tx = session.beginTransaction();

		Query<Country> query = session.createQuery(hqlQuery, Country.class);

		List<Country> list = query.list();
		session.getTransaction().commit();
		session.close();

		try {

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;

	}

	public String addEmployee(Employee emp) {
		Session session = null;
		Transaction tx = null;

		String msg = null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();

			session.persist(emp);
			tx.commit();
			msg = "Employee Added Successfully";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	public String updateEmployee(Employee emp) {

		Session session = null;
		Transaction tx = null;

		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Employee employee = session.get(Employee.class, emp.getId());

			employee.setName(emp.getName());
			employee.setCountry(emp.getCountry());
			employee.setCreatedby(emp.getCreatedby());
			employee.setCreateddtm(emp.getCreateddtm());
			employee.setUpdateddby(emp.getUpdateddby());
			employee.setUpdateDate(emp.getUpdateDate());
			employee.setDepartment(emp.getDepartment());
			employee.setStatus(emp.getStatus());
			employee.setSalary(emp.getSalary());
			employee.setEmailid(emp.getEmailid());
			employee.setPhoneno(emp.getPhoneno());

			session.merge(employee);
			tx.commit();
			msg = "Employee updated";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return msg;
	}

	public String deleteEmployee(int id) {

		Session session = null;
		Transaction tx = null;

		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Employee employee = session.get(Employee.class, id);

			session.remove(employee);
			tx.commit();
			session.close();
			return "Record Delete Successfully";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return msg;
	}

	public List<Employee> getAllRecordemp() {

		Session session = null;
		Transaction tx = null;

		String hqlQuery = "from Employee";

		session = factory.openSession();
		tx = session.beginTransaction();

		Query<Employee> query = session.createQuery(hqlQuery, Employee.class);

		List<Employee> list = query.list();
		session.getTransaction().commit();
		session.close();

		try {

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;

	}

	public Employee getParticularRecordemp(int id) {

		Session session = null;
		Transaction tx = null;

		Employee emp = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			emp = session.get(Employee.class, id);

			session.get(Employee.class, id);
			tx.commit();
			session.close();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return emp;

	}

	public List<Employee> getDatabyStatus(String status) {

		Session session = null;
		Transaction tx = null;

		List<Employee> list = null;
		String hqlQuery = "FROM Employee WHERE status = :status";

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			

			tx.commit();
			session.close();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return list;

	}

	public Employee loginApi(Employee emp) {

		Session session = null;
		Transaction tx = null;
		Employee employee = null;

		String hqlQuery = "from Employee where emailid=:myemailid and phoneno=:phoneno";

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);

			query.setParameter("myemailid", emp.getEmailid());
			query.setParameter("phoneno", emp.getPhoneno());

			employee = query.uniqueResult();

			tx.commit();
			

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return employee;

	}

}
