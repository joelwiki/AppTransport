import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class horairesC1 implements Runnable {
	private int heures ;
	private int minutes ;
	private int day;
	protected JFrame frame;
	protected JLabel lblMaupertuis;
	protected JLabel lblJeanMace;
	protected JFrame fenetre;

	public horairesC1(JLabel lblMaupertuis , JLabel lblJeanMace, JFrame fenetre) {

		this.frame=fenetre;
		this.lblMaupertuis=lblMaupertuis;
		this.lblJeanMace=lblJeanMace;

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run()
			{
				MajC1Maupertuis();
				MajC1JeanMace();
				frame.repaint();
			}

			private void MajC1JeanMace() {
				Calendar cal =  Calendar.getInstance();
				minutes = cal.get(Calendar.MINUTE);
				heures =cal.get(Calendar.HOUR_OF_DAY) ;
				int day = cal.get(Calendar.DAY_OF_WEEK);

				ArrayList<String> listeHorairesJeanMace = new ArrayList();
				//System.out.println("Jean Mace <-- C1");

				try {
					String ecrire ="";
					boolean J = true;

					int heuresMaupertuis = heures;
					int minutesMaupertuis = minutes;

					int heuresJeanMace = heuresMaupertuis;
					int minutesJeanMace=minutesMaupertuis;

					/*********************************************************************************************************************/

					JSONParser parser = new JSONParser();

					URL web = new URL("https://data.metromobilite.fr/api/routers/default/index/stops/SEM:1994"+"/stoptimes");

					URLConnection connect = web.openConnection();
					//Buffered in buffer
					BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));

					JSONArray jsonObject = (JSONArray) parser.parse(in);

					Iterator i = jsonObject.iterator();

					while(i.hasNext()) {
						JSONObject innerObj = (JSONObject) i.next();
						//System.out.println("times is : " + innerObj.get("times"));

						JSONArray array = (JSONArray) innerObj.get("times");

						Iterator j = array.iterator();
						int verite = 0;
						while(j.hasNext()==J) {
							if(verite==1) {
								J=false;
							}else {
								JSONObject Obj = (JSONObject) j.next();
								ecrire = (String) Obj.get("realtimeArrival").toString();
								//System.out.println("Arrivé prévu " + Obj.get("realtimeArrival"));
								verite++;
							}
						}
						int intParse = Integer.parseInt(ecrire);

						//System.out.println(intParse);
						float c = intParse;
						int h = intParse;
						int b = 3600;

						float divided = h/b;
						float reel = c/b;

						//System.out.println(reel);
						//System.out.println(divided);

						float resultatFinal = (float) ((((reel-divided)/100)*60*100)+0.0001);

						System.out.println("Le prochain passage du bus est a "+(int)divided+":"+(int)resultatFinal );

						if(minutesJeanMace<10){
							lblJeanMace.setText("Passage a "+(int)divided+":"+(int)resultatFinal);
						}else{
							lblJeanMace.setText("Passage a "+(int)divided+":"+(int)resultatFinal);
						}

					}

					in.close();





				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					System.out.println("Pb de parse");
					e.printStackTrace();
				}


			}

			private void MajC1Maupertuis() {

				Calendar cal =  Calendar.getInstance();
				minutes = cal.get(Calendar.MINUTE);
				heures =cal.get(Calendar.HOUR_OF_DAY) ;
				int day = cal.get(Calendar.DAY_OF_WEEK);

				ArrayList<String> listeHorairesMaupertuis = new ArrayList();
				System.out.println("C1--> Maupertuis");

				try {
					String ecrire ="";
					boolean J = true;

					int heuresMaupertuis = heures;
					int minutesMaupertuis = minutes;

					int heuresJeanMace = heuresMaupertuis;
					int minutesJeanMace=minutesMaupertuis;

					/*********************************************************************************************************************/

					JSONParser parser = new JSONParser();

					URL web = new URL("https://data.metromobilite.fr/api/routers/default/index/stops/SEM:1995"+"/stoptimes");

					URLConnection connect = web.openConnection();
					//Buffered in buffer
					BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));

					JSONArray jsonObject = (JSONArray) parser.parse(in);

					Iterator i = jsonObject.iterator();

					while(i.hasNext()) {
						JSONObject innerObj = (JSONObject) i.next();
						//System.out.println("times is : " + innerObj.get("times"));

						JSONArray array = (JSONArray) innerObj.get("times");

						Iterator j = array.iterator();
						int verite = 0;
						while(j.hasNext()==J) {
							if(verite==1) {
								J=false;
							}else {
								JSONObject Obj = (JSONObject) j.next();
								ecrire = (String) Obj.get("realtimeArrival").toString();
								//System.out.println("Arrivé prévu " + Obj.get("realtimeArrival"));
								verite++;
							}
						}
						int intParse = Integer.parseInt(ecrire);

						//System.out.println(intParse);
						float c = intParse;
						int h = intParse;
						int b = 3600;

						float divided = h/b;
						float reel = c/b;

						//System.out.println(reel);
						//System.out.println(divided);

						float resultatFinal = (float) ((((reel-divided)/100)*60*100)+0.0001);

						System.out.println("Le prochain passage du bus est a "+(int)divided+":"+(int)resultatFinal );

						if(minutesJeanMace<10){
							lblMaupertuis.setText("Passage a "+(int)divided+":"+(int)resultatFinal);
						}else{
							lblMaupertuis.setText("Passage a "+(int)divided+":"+(int)resultatFinal);
						}

					}






				}catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
				};
			}

		},0, 10000);
	}


	@Override
	public void run() {
	}
}



