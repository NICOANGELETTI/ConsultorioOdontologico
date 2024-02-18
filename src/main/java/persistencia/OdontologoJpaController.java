/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Turno;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;
import logica.Odontologo;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.RollbackFailureException;

/**
 *
 * @author nicoc
 */
public class OdontologoJpaController implements Serializable {

    public OdontologoJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
  public  OdontologoJpaController(){
        emf = Persistence.createEntityManagerFactory("ConsultorioOdontologiaFinal_PU");
    }
  
  
  
  
  
      public void create(Odontologo odontologo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(odontologo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
//    public void create(Odontologo odontologo) throws RollbackFailureException, Exception {
//        if (odontologo.getListaTurnos() == null) {
//            odontologo.setListaTurnos(new ArrayList<Turno>());
//        }
//        EntityManager em = null;
//        try {
//            utx.begin();
//            em = getEntityManager();
//            List<Turno> attachedListaTurnos = new ArrayList<Turno>();
//            for (Turno listaTurnosTurnoToAttach : odontologo.getListaTurnos()) {
//                listaTurnosTurnoToAttach = em.getReference(listaTurnosTurnoToAttach.getClass(), listaTurnosTurnoToAttach.getId_turno());
//                attachedListaTurnos.add(listaTurnosTurnoToAttach);
//            }
//            odontologo.setListaTurnos(attachedListaTurnos);
//            em.persist(odontologo);
//            for (Turno listaTurnosTurno : odontologo.getListaTurnos()) {
//                Odontologo oldOdontoOfListaTurnosTurno = listaTurnosTurno.getOdonto();
//                listaTurnosTurno.setOdonto(odontologo);
//                listaTurnosTurno = em.merge(listaTurnosTurno);
//                if (oldOdontoOfListaTurnosTurno != null) {
//                    oldOdontoOfListaTurnosTurno.getListaTurnos().remove(listaTurnosTurno);
//                    oldOdontoOfListaTurnosTurno = em.merge(oldOdontoOfListaTurnosTurno);
//                }
//            }
//            utx.commit();
//        } catch (Exception ex) {
//            try {
//                utx.rollback();
//            } catch (Exception re) {
//                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
//            }
//            throw ex;
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }

    public void edit(Odontologo odontologo) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Odontologo persistentOdontologo = em.find(Odontologo.class, odontologo.getId());
            List<Turno> listaTurnosOld = persistentOdontologo.getListaTurnos();
            List<Turno> listaTurnosNew = odontologo.getListaTurnos();
            List<Turno> attachedListaTurnosNew = new ArrayList<Turno>();
            for (Turno listaTurnosNewTurnoToAttach : listaTurnosNew) {
                listaTurnosNewTurnoToAttach = em.getReference(listaTurnosNewTurnoToAttach.getClass(), listaTurnosNewTurnoToAttach.getId_turno());
                attachedListaTurnosNew.add(listaTurnosNewTurnoToAttach);
            }
            listaTurnosNew = attachedListaTurnosNew;
            odontologo.setListaTurnos(listaTurnosNew);
            odontologo = em.merge(odontologo);
            for (Turno listaTurnosOldTurno : listaTurnosOld) {
                if (!listaTurnosNew.contains(listaTurnosOldTurno)) {
                    listaTurnosOldTurno.setOdonto(null);
                    listaTurnosOldTurno = em.merge(listaTurnosOldTurno);
                }
            }
            for (Turno listaTurnosNewTurno : listaTurnosNew) {
                if (!listaTurnosOld.contains(listaTurnosNewTurno)) {
                    Odontologo oldOdontoOfListaTurnosNewTurno = listaTurnosNewTurno.getOdonto();
                    listaTurnosNewTurno.setOdonto(odontologo);
                    listaTurnosNewTurno = em.merge(listaTurnosNewTurno);
                    if (oldOdontoOfListaTurnosNewTurno != null && !oldOdontoOfListaTurnosNewTurno.equals(odontologo)) {
                        oldOdontoOfListaTurnosNewTurno.getListaTurnos().remove(listaTurnosNewTurno);
                        oldOdontoOfListaTurnosNewTurno = em.merge(oldOdontoOfListaTurnosNewTurno);
                    }
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = odontologo.getId();
                if (findOdontologo(id) == null) {
                    throw new NonexistentEntityException("The odontologo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Odontologo odontologo;
            try {
                odontologo = em.getReference(Odontologo.class, id);
                odontologo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The odontologo with id " + id + " no longer exists.", enfe);
            }
            List<Turno> listaTurnos = odontologo.getListaTurnos();
            for (Turno listaTurnosTurno : listaTurnos) {
                listaTurnosTurno.setOdonto(null);
                listaTurnosTurno = em.merge(listaTurnosTurno);
            }
            em.remove(odontologo);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Odontologo> findOdontologoEntities() {
        return findOdontologoEntities(true, -1, -1);
    }

    public List<Odontologo> findOdontologoEntities(int maxResults, int firstResult) {
        return findOdontologoEntities(false, maxResults, firstResult);
    }

    private List<Odontologo> findOdontologoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Odontologo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Odontologo findOdontologo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Odontologo.class, id);
        } finally {
            em.close();
        }
    }

    public int getOdontologoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Odontologo> rt = cq.from(Odontologo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
