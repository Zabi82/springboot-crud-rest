// Generated with g9.

package com.zabeer.sbmysql.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="skill")
public class Skill implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "id";

    /**
     * The optimistic lock. Available via standard bean get/set operations.
     */
//    @Version
//    @Column(name="LOCK_FLAG")
//    private Integer lockFlag;

    /**
     * Access method for the lockFlag property.
     *
     * @return the current value of the lockFlag property
     */
//    public Integer getLockFlag() {
//        return lockFlag;
//    }

    /**
     * Sets the value of the lockFlag property.
     *
     * @param aLockFlag the new value of the lockFlag property
     */
//    public void setLockFlag(Integer aLockFlag) {
//        lockFlag = aLockFlag;
//    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, length=10)
    private int id;
    @Column(length=100)
    private String name;
    @Column(length=500)
    private String description;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "skills")
    
    @JsonIgnoreProperties("skills")
    private Set<Developer> developers;

    /** Default constructor. */
    public Skill() {
        super();
    }

    /**
     * Access method for id.
     *
     * @return the current value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(int aId) {
        id = aId;
    }

    /**
     * Access method for name.
     *
     * @return the current value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for name.
     *
     * @param aName the new value for name
     */
    public void setName(String aName) {
        name = aName;
    }

    /**
     * Access method for description.
     *
     * @return the current value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter method for description.
     *
     * @param aDescription the new value for description
     */
    public void setDescription(String aDescription) {
        description = aDescription;
    }

    /**
     * Access method for developerSkill.
     *
     * @return the current value of developerSkill
     */
    public Set<Developer> getDevelopers() {
        return developers;
    }

    /**
     * Setter method for developerSkill.
     *
     * @param aDeveloperSkill the new value for developerSkill
     */
    public void setDevelopers(Set<Developer> aDevelopers) {
        developers = aDevelopers;
    }

    /**
     * Compares the key for this instance with another Skill.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Skill and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Skill)) {
            return false;
        }
        Skill that = (Skill) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Skill.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Skill)) return false;
        return this.equalKeys(other) && ((Skill)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Skill |");
        sb.append(" id=").append(getId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
//    public Map<String, Object> getPrimaryKey() {
//        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
//        ret.put("id", Integer.valueOf(getId()));
//        return ret;
//    }

}
