package br.com.cad.repository;

import java.util.List;

import org.hibernate.Session;

import br.com.cad.utils.HibernateUtils;

import org.hibernate.Transaction;

import br.com.cad.model.CadastroModel;

public class CadRepository {

	public void saveCadastro(CadastroModel cad) {

		Transaction transaction = null;

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(cad);
			transaction.commit();
		} catch (Exception e) {
			//if (transaction != null) {
			//	transaction.rollback();
			//}
		}
	}

	public void updateCad(CadastroModel cad) {

		Transaction transaction = null;

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.saveOrUpdate(cad);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public CadastroModel getByID(Long id) {

		Transaction transaction = null;
		CadastroModel cad = null;

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			cad = session.get(CadastroModel.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return cad;
	}

	@SuppressWarnings("unchecked")
	public List<CadastroModel> getAll() {

		Transaction transaction = null;
		List<CadastroModel> cad = null;

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			cad = session.createQuery("from Cadastro").list();
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return cad;
	}
	
	public void DeletaCadastro(Long id) {

		Transaction transaction = null;
		CadastroModel cad = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();			
			cad = session.get(CadastroModel.class, id);
			session.delete(cad);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		
	}
}
