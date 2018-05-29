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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class horairesL13 implements Runnable {

	JLabel lblLGM;
	JLabel lblPremol;
	JFrame frame;



	public horairesL13(JLabel lblLGM, JLabel lblPremol, JFrame fenetre) {

		this.lblLGM=lblLGM;
		this.lblPremol=lblPremol;
		this.frame=fenetre;


		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			private int minutes;
			private int heures;

			public void run()
			{
				Maj13LGM();
				MajC1Premol();
				frame.repaint();
			}


			private void Maj13LGM() {
				Calendar cal =  Calendar.getInstance();
				minutes = cal.get(Calendar.MINUTE);
				heures =cal.get(Calendar.HOUR_OF_DAY) ;
				int day = cal.get(Calendar.DAY_OF_WEEK);



				try {
					String ecrire ="";
					boolean J = true;

					int heuresMaupertuis = heures;
					int minutesMaupertuis = minutes;

					int heuresJeanMace = heuresMaupertuis;
					int minutesJeanMace=minutesMaupertuis;

					/*********************************************************************************************************************/

					JSONParser parser = new JSONParser();

					URL web = new URL("https://data.metromobilite.fr/api/routers/default/index/stops/SEM:0330"+"/stoptimes");

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
							lblLGM.setText("Passage a "+(int)divided+":"+(int)resultatFinal);
						}else{
							lblLGM.setText("Passage a "+(int)divided+":"+(int)resultatFinal);
						}
					}
				} catch (IOException e) {

					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			private void MajC1Premol() {
				Calendar cal =  Calendar.getInstance();
				minutes = cal.get(Calendar.MINUTE);
				heures =cal.get(Calendar.HOUR_OF_DAY) ;
				int day = cal.get(Calendar.DAY_OF_WEEK);



				try {
					String ecrire ="";
					boolean J = true;

					int heuresMaupertuis = heures;
					int minutesMaupertuis = minutes;

					int heuresJeanMace = heuresMaupertuis;
					int minutesJeanMace=minutesMaupertuis;

					/*********************************************************************************************************************/

					JSONParser parser = new JSONParser();

					URL web = new URL("https://data.metromobilite.fr/api/routers/default/index/stops/SEM:0368"+"/stoptimes");

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
							lblPremol.setText("Passage a "+(int)divided+":"+(int)resultatFinal);
						}else{
							lblPremol.setText("Passage a "+(int)divided+":"+(int)resultatFinal);
						}
					}
				} catch (IOException e) {

					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}




			}

		},0, 10000);



	}


	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
