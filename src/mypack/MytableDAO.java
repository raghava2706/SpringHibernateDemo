package mypack;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Mytable entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see mypack.Mytable
 * @author MyEclipse Persistence Tools
 */
public class MytableDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(MytableDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String LOCATION = "location";
	public static final String EMAIL = "email";

	protected void initDao() {
		// do nothing
	}

	public void save(Mytable transientInstance) {
		log.debug("saving Mytable instance");
		try {
			Transaction tx = getHibernateTemplate().getSessionFactory().openSession().beginTransaction();
			getHibernateTemplate().save(transientInstance);
			tx.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Mytable persistentInstance) {
		log.debug("deleting Mytable instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Mytable findById(java.math.BigDecimal id) {
		log.debug("getting Mytable instance with id: " + id);
		try {
			Mytable instance = (Mytable) getHibernateTemplate().get(
					"mypack.Mytable", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Mytable instance) {
		log.debug("finding Mytable instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Mytable instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Mytable as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByLocation(Object location) {
		return findByProperty(LOCATION, location);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findAll() {
		log.debug("finding all Mytable instances");
		try {
			String queryString = "from Mytable";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Mytable merge(Mytable detachedInstance) {
		log.debug("merging Mytable instance");
		try {
			Mytable result = (Mytable) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Mytable instance) {
		log.debug("attaching dirty Mytable instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Mytable instance) {
		log.debug("attaching clean Mytable instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MytableDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MytableDAO) ctx.getBean("MytableDAO");
	}
}