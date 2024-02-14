/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import logica.Odontologo;
import logica.Paciente;
import logica.Turno;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.RollbackFailureException;

/**
 *
 * @author nicoc
 */
public class TurnoJpaController implements Serializable {

    public TurnoJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
  public  TurnoJpaController(){
        emf = Persistence.createEntityManagerFactory("ConsultorioOdontologiaFinal_PU");
    }
    public void create(Turno turno) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Odontologo odonto = turno.getOdonto();
            if (odonto != null) {
                odonto = em.getReference(odonto.getClass(), odonto.getId());
                turno.setOdonto(odonto);
            }
            Paciente paciente = turno.getPaciente();
            if (paciente != null) {
                paciente = em.getReference(paciente.getClass(), paciente.getId());
                turno.setPaciente(paciente);
            }
            em.persist(turno);
            if (odonto != null) {
                odonto.getListaTurnos().add(turno);
                odonto = em.merge(odonto);
            }
            if (paciente != null) {
                paciente.getListaTurnos().add(turno);
                paciente = em.merge(paciente);
            }
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

    public void edit(Turno turno) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Turno persistentTurno = em.find(Turno.class, turno.getId_turno());
            Odontologo odontoOld = persistentTurno.getOdonto();
            Odontologo odontoNew = turno.getOdonto();
            Paciente pacienteOld = persistentTurno.getPaciente();
            Paciente pacienteNew = turno.getPaciente();
            if (odontoNew != null) {
                odontoNew = em.getReference(odontoNew.getClass(), odontoNew.getId());
                turno.setOdonto(odontoNew);
            }
            if (pacienteNew != null) {
                pacienteNew = em.getReference(pacienteNew.getClass(), pacienteNew.getId());
                turno.setPaciente(pacienteNew);
            }
            turno = em.merge(turno);
            if (odontoOld != null && !odontoOld.equals(odontoNew)) {
                odontoOld.getListaTurnos().remove(turno);
                odontoOld = em.merge(odontoOld);
            }
            if (odontoNew != null && !odontoNew.equals(odontoOld)) {
                odontoNew.getListaTurnos().add(turno);
                odontoNew = em.merge(odontoNew);
            }
            if (pacienteOld != null && !pacienteOld.equals(pacienteNew)) {
                pacienteOld.getListaTurnos().remove(turno);
                pacienteOld = em.merge(pacienteOld);
            }
            if (pacienteNew != null && !pacienteNew.equals(pacienteOld)) {
                pacienteNew.getListaTurnos().add(turno);
                pacienteNew = em.merge(pacienteNew);
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
                int id = turno.getId_turno();
                if (findTurno(id) == null) {
                    throw new NonexistentEntityException("The turno with id " + id + " no longer exists.");
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
            Turno turno;
            try {
                turno = em.getReference(Turno.class, id);
                turno.getId_turno();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The turno with id " + id + " no longer exists.", enfe);
            }
            Odontologo odonto = turno.getOdonto();
            if (odonto != null) {
                odonto.getListaTurnos().remove(turno);
                odonto = em.merge(odonto);
            }
            Paciente paciente = turno.getPaciente();
            if (paciente != null) {
                paciente.getListaTurnos().remove(turno);
                paciente = em.merge(paciente);
            }
            em.remove(turno);
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

    public List<Turno> findTurnoEntities() {
        return findTurnoEntities(true, -1, -1);
    }

    public List<Turno> findTurnoEntities(int maxResults, int firstResult) {
        return findTurnoEntities(false, maxResults, firstResult);
    }

    private List<Turno> findTurnoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Turno.class));
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

    public Turno findTurno(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Turno.class, id);
        } finally {
            em.close();
        }
    }

    public int getTurnoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Turno> rt = cq.from(Turno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
