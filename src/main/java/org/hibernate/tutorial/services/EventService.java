package org.hibernate.tutorial.services;

import java.util.Date;

import org.hibernate.tutorial.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class EventService {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void addOne(Event theEvent) {
		// theEvent.setTitle("这是事件标题");
		// theEvent.setDate(new Date());
//		theEvent.setId(1L);
		hibernateTemplate.save(theEvent);

		addTwo(theEvent);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
	public void addTwo(Event theEvent) {
		try {
			Event e = new Event();
//			e.setId(2L);
			e.setTitle(null);
			e.setDate(new Date());
			hibernateTemplate.save(e);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
