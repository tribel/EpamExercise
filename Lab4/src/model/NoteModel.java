package model;

import java.util.ArrayList;
import java.util.List;

import entity.Notebook;

/**
 * Model class 
 * @author Tribel
 *
 */
public class NoteModel {
	
	private List<Notebook> notebooks;

	public NoteModel() {
		notebooks = new ArrayList<>();
	}

	public List<Notebook> getNotebooks() {
		return notebooks;
	}

	public void setNotebooks(List<Notebook> notebooks) {
		this.notebooks = notebooks;
	}
	
	/**
	 * Adding {@link Notebook} entity to list
	 * @param notebook
	 */
	public void addNotebook(Notebook notebook) {
		notebooks.add(notebook);
	}
	
}
