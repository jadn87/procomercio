package co.com.procomercio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author 1018408725
 */
@Entity
@Table(name = "categories")
public class Category implements Serializable { 
	
	private static final long serialVersionUID = 1L;
    
    @Id
    private String id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="parent")
    private String parent;
    @Column(name="eliminated")
    private boolean eliminated;

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public boolean isEliminated() {
        return eliminated;
    }

    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }
    
    
}
