package service;

import java.util.ArrayList;
import java.util.List;
import entity.Timetable;

public class TimetableService {
    private static TimetableService instance = null;
    private List<Timetable> timetables;

    private TimetableService() {
        timetables = new ArrayList<>();
    }

    public static synchronized TimetableService getInstance() {
        if (instance == null) {
            instance = new TimetableService();
        }
        return instance;
    }

    public Timetable insert(Timetable timetable) {
        // Add your implementation for inserting a timetable into the database or data source
        // Example: Assume the timetable has an auto-generated ID from the database
        int newId = getNextAvailableId();
        timetable.setId(newId);
        timetables.add(timetable);
        return timetable;
    }

    public Timetable update(Timetable timetable) {
        // Add your implementation for updating a timetable in the database or data source
        // Example: Update the timetable with the given ID
        for (Timetable existingTimetable : timetables) {
            if (existingTimetable.getId() == timetable.getId()) {
                // Update the timetable details
                existingTimetable.setCourses(timetable.getCourses());
                return existingTimetable;
            }
        }
        return null; // Return null if the timetable with the given ID is not found
    }

    public boolean delete(int id) {
        // Add your implementation for deleting a timetable from the database or data source
        // Example: Delete the timetable with the given ID
        for (Timetable existingTimetable : timetables) {
            if (existingTimetable.getId() == id) {
                timetables.remove(existingTimetable);
                return true; // Return true if deletion is successful
            }
        }
        return false; // Return false if the timetable with the given ID is not found
    }

    public List<Timetable> findAll() {
        // Return the list of timetables
        return timetables;
    }

    public Timetable findById(int id) {
        // Add your implementation for finding a timetable by ID in the database or data source
        // Example: Find the timetable with the given ID
        for (Timetable existingTimetable : timetables) {
            if (existingTimetable.getId() == id) {
                return existingTimetable;
            }
        }
        return null; // Return null if the timetable with the given ID is not found
    }

    // Helper method to simulate auto-incrementing IDs (replace with database-generated IDs)
    private int getNextAvailableId() {
        int maxId = 0;
        for (Timetable existingTimetable : timetables) {
            maxId = Math.max(maxId, existingTimetable.getId());
        }
        return maxId + 1;
    }
}
