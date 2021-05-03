package edu.uptc.models;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RunnableModule implements Runnable{
	public static int time;
	private boolean status = false;
	private long initialTime = System.currentTimeMillis();
	private User user;
	private ArrayList<String> stad;
	private int userAcumulado=0, tiempoAcumulado=0;
	
	public RunnableModule() {
		initialTime = 0;
		this.user = new User();
	}

	@Override
	public void run() {
		
		time = new Random().nextInt(4000)+500;
		
		initialTime += time;
		System.out.println(time);
		for(int i = 0; i <= 10; i++) {
			try {
				Thread.sleep(time);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if(user.getProcedure().equals("Autorizaciones"))
		{
			userAcumulado= userAcumulado+1;
			tiempoAcumulado+=time/100;
			System.out.println(formatearMinutosAHoraMinuto(time/100));
			
		}else if(user.getProcedure().equals("Asignacion_citas"))
		{
			userAcumulado = userAcumulado+1;
			tiempoAcumulado+=time/100;
		}else if(user.getProcedure().equals("Entrega_medicamentos"))
		{
			userAcumulado = userAcumulado+1;
			tiempoAcumulado+=time/100;
		}else if (user.getProcedure().equals("Laboratorios"))
		{
			userAcumulado = userAcumulado+1;
			tiempoAcumulado+=time/100;
		}
		
		setStatus(false);
	}
	
	public int getTiempoAcumulado() {
		return tiempoAcumulado;
	}

	public void setTiempoAcumulado(int tiempoAcumulado) {
		this.tiempoAcumulado = tiempoAcumulado;
	}

	public String formatearMinutosAHoraMinuto(int minutos) {
	    String formato = "%02d:%02d";
	    long horasReales = TimeUnit.MINUTES.toHours(minutos);
	    long minutosReales = TimeUnit.MINUTES.toMinutes(minutos) - TimeUnit.HOURS.toMinutes(TimeUnit.MINUTES.toHours(minutos));
	    return String.format(formato, horasReales, minutosReales);
	}


	public int getA() {
		return userAcumulado;
	}

	public void setA(int a) {
		this.userAcumulado = a;
	}

	public long getTimeWorked() {
		return initialTime;
	}
	
	public User getUser() {
		return user;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setTimeWorked(int timeWorked) {
		this.initialTime = timeWorked;
	}
	
	public void setUser(User user) {
		this.user = user;
	}	
	
	public static int tiempo() {
		return Thread.activeCount();
	}
}