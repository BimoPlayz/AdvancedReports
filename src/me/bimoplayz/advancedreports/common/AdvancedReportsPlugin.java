package me.bimoplayz.advancedreports.common;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface AdvancedReportsPlugin {
	
	  void log(Level level, String label);
	  
	  void log(Level level, String label, Throwable throwable);
	  
	  Logger getLogger();
	  
	  void scheduleAsync(Runnable runnable);
	  
	  <T> Future<T> callSyncMethod(Callable<T> callable);
	  
	  <T> Future<T> callAsyncMethod(Callable<T> callable);
	  
	  void logException(Throwable throwable);
	  
	  boolean getConfigBoolean(String label);
	  
	  ThreadFactory getThreadFactory();
}
