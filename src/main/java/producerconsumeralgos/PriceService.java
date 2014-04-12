package producerconsumeralgos;

import java.util.concurrent.ExecutionException;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 11/03/13
 * Time: 08:25
 * To change this template use File | Settings | File Templates.
 */
public interface PriceService {
   void addListener(final String name, final Listener listener);
   void removeListener(final String name, final Listener listner) throws ExecutionException, InterruptedException;
   void notifyListeners(final String name, final Event e);
}

interface Listener {
   //usually this will take some kind of event object
   void onEvent(Event event);
}

interface Event{}



