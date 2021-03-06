package org.moskito.control;

import org.moskito.control.core.ApplicationRepository;
import org.moskito.control.core.history.StatusUpdateHistoryRepository;
import org.moskito.control.core.updater.ApplicationStatusUpdater;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.moskito.control.core.updater.ChartDataUpdater;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContextListener that ensures that MoSKito-Control components are started in proper order.
 *
 * @author lrosenberg
 * @since 28.05.13 21:15
 */
public class StartListener implements ServletContextListener{

	static{
		BasicConfigurator.configure();
	}

	/**
	 * Logger.
	 */
	private static Logger log = Logger.getLogger(StartListener.class);

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		log.info("Starting up MoSKito Control...");

		ApplicationRepository.getInstance();
		log.info("ApplicationRepository loaded.");

		//initialize history
		StatusUpdateHistoryRepository.getInstance();
		log.info("StatusUpdateHistoryRepository loaded.");

		ApplicationStatusUpdater.getInstance();
		log.info("Application Status Updater loaded.");

		ChartDataUpdater.getInstance();
		log.info("ChartData Updater loaded.");


		log.info("MoSKito Control started.");

	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

	}
}
