package org.example;
import java.util.ArrayList;
import java.util.List;

public class Library implements IManageable {
    private List<Item> items;
    private List<Patron> patrons;

    public Library() {
        this.items = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public void remove(Item item) {
        items.remove(item);
    }

    @Override
    public void listAvailable() {
        System.out.println("Available Items:");
        for (Item item : items) {
            if (!item.isBorrowed()) {
                System.out.println(item.getTitle() + " (" + item.getUniqueID() + ")");
            }
        }
    }

    @Override
    public void listBorrowed() {
        System.out.println("Borrowed Items:");
        for (Patron patron : patrons) {
            for (Item item : patron.getBorrowedItems()) {
                System.out.println(item.getTitle() + " (" + item.getUniqueID() + ") - Borrowed by: " + patron.getName());
            }
        }
    }

    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    public void lendItem(Patron patron, Item item) {
        if (!item.isBorrowed()) {
            patron.borrow(item);
        } else {
            System.out.println("Item is already borrowed.");
        }
    }

    public void returnItem(Patron patron, Item item) {
        if (patron.getBorrowedItems().contains(item)) {
            patron.returnItem(item);
        } else {
            System.out.println("Patron did not borrow this item.");
        }
    }
}