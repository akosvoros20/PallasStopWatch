package hu.stopwatch;
import javax.swing.JFrame;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class StopWatch {

	public static void main(String[] args) {
		Resource resource= new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		Watch watch = (Watch)factory.getBean("windowsize");
		watch.setupGui();
	}

}
