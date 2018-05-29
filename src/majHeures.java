import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class majHeures implements Runnable {
	protected int heures ;
	protected int minutes;
	
	protected JLabel lblheures;
	//protected JFrame frame;
	protected int secondes;
	
	protected JFrame frame;

	public majHeures(JLabel labelHeures, JFrame fenetre) {
		this.frame=fenetre;
		this.lblheures=labelHeures;

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run()
			{
				majHeures();
				frame.repaint();

			}

			private void majHeures() {
				Calendar cal = Calendar.getInstance();
				//System.out.println("Hello");
				heures=cal.get(Calendar.HOUR_OF_DAY);
				minutes=cal.get(Calendar.MINUTE);
				secondes=cal.get(Calendar.SECOND);

				if(heures<=9 & minutes <=9){
					lblheures.setText("Il est : "+heures+": "+ minutes +":"+ secondes);
				}else{
					lblheures.setText("Il est :"+heures+":"+ minutes+":"+secondes);

				}				
				
			}
		},0, 1000);




	}

	@Override
	public void run() {

	}


}
