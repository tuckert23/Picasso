package picasso.util;

import java.lang.reflect.InvocationTargetException;

/**
 * An abstract command class that operates on some target object.
 * 
 * @author Robert C Duvall
 */
public interface Command<T> {

	public void execute(T target);
}
