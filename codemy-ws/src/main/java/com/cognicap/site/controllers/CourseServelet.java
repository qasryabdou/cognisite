package com.cognicap.site.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognicap.codemy.core.persistence.domain.Course;
import com.cognicap.codemy.core.persistence.domain.Seance;
import com.cognicap.codemy.core.persistence.domain.Session;
import com.cognicap.codemy.core.repository.CourseRepository;
import com.cognicap.codemy.core.repository.SeanceRepository;
import com.cognicap.codemy.core.repository.SessionRepository;

/**
 * Servlet implementation class CourseServelet
 */
public class CourseServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CourseRepository courseRepository = context
				.getBean(CourseRepository.class);
		SessionRepository sessionRepository = context
				.getBean(SessionRepository.class);
		SeanceRepository seanceRepository = context
				.getBean(SeanceRepository.class);
		
		
		//creer et inserer les sessions
				List<Seance> seances1 = new ArrayList<Seance>();
				Seance s11=new Seance("jsp", "2012-07-19");
				seances1.add(s11);
				Seance s12=new Seance("jsp suite", "2012-07-24");
				seances1.add(s12);
				seanceRepository.createSeanceCollection();
				seanceRepository.insertSeance(s11);
				seanceRepository.insertSeance(s12);
				
				List<Seance> seances2 = new ArrayList<Seance>();
				Seance s21=new Seance("servelet", "2012-09-19");
				seances2.add(s21);
				Seance s22=new Seance("servelet suite", "2012-09-24");
				seances2.add(s22);
				seanceRepository.createSeanceCollection();
				seanceRepository.insertSeance(s21);
				seanceRepository.insertSeance(s22);
				
		
		//creer et inserer les sessions
		List<Session> sessions = new ArrayList<Session>();
		Session s1=new Session("2012-07-19","2012-09-19", "Nabil Moursli",seances1);
		sessions.add(s1);
		Session s2=new Session("2012-09-19","2012-11-19", "Nabil Moursli",seances2);
		sessions.add(s2);
		sessionRepository.createSessionCollection();
		sessionRepository.insertSession(s1);
		sessionRepository.insertSession(s2);
		
		//creer et inserer le cours
		Course p = new Course("java","cours Java",sessions);
		courseRepository.createCourseCollection();
		courseRepository.insertCourse(p);
		
	}

}
