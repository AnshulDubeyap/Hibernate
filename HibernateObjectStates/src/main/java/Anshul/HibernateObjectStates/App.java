package Anshul.HibernateObjectStates;

/**
 * Hello world!
 *
 */
public class App 

{
	// Persistant Life Cycle
		// Refers to the different states an object can be in while being managed by a Hibernate session.
		// The life cycle begins when an object is created and ends when it is detached or removed.
		
		// Different states
		// 1. Transient: An object is in this state when it is a new instance and has no association with a Hibernate Session.
		// 2. Persistent: An object is in this state after it has been associated with a Session. Any changes to the object will be synchronized with the database.
		// 3. Detached: An object is in this state when it was previously persistent, but is no longer associated with a Session. Changes to a detached object will not be synchronized with the database.
		// 4. Removed: An object is in this state when its corresponding row is scheduled for deletion from the database.
		
		// How to get from one State to another
		// Transient -> Persistent: Use session.persist(), session.save(), or session.merge().
		// Persistent -> Detached: Close the session, or use session.clear() or session.evict().
		// Persistent -> Removed: Use session.remove() or session.delete().
		// Detached -> Persistent: Use session.update() or session.merge().
	
    public static void main( String[] args )
    {
        
    	
    }
}
