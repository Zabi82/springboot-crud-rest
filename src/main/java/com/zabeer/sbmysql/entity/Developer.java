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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="developer")
public class Developer implements Serializable {

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
    @Column(name="first_name", length=100)
    private String firstName;
    @Column(name="last_name", length=100)
    private String lastName;
    
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    
    @JsonIgnoreProperties("developers")
    @JoinTable(name = "developer_skill",
            joinColumns = { @JoinColumn(name = "developer_id") },
            inverseJoinColumns = { @JoinColumn(name = "skill_id") })
    private Set<Skill> skills;

    /** Default constructor. */
    public Developer() {
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
     * Access method for firstName.
     *
     * @return the current value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter method for firstName.
     *
     * @param aFirstName the new value for firstName
     */
    public void setFirstName(String aFirstName) {
        firstName = aFirstName;
    }

    /**
     * Access method for lastName.
     *
     * @return the current value of lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter method for lastName.
     *
     * @param aLastName the new value for lastName
     */
    public void setLastName(String aLastName) {
        lastName = aLastName;
    }

    /**
     * Access method for developerSkill.
     *
     * @return the current value of developerSkill
     */
    public Set<Skill> getSkills() {
        return skills;
    }

    /**
     * Setter method for developerSkill.
     *
     * @param aDeveloperSkill the new value for developerSkill
     */
    public void setSkills(Set<Skill> aSkills) {
        skills = aSkills;
    }

    /**
     * Compares the key for this instance with another Developer.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Developer and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Developer)) {
            return false;
        }
        Developer that = (Developer) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Developer.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Developer)) return false;
        return this.equalKeys(other) && ((Developer)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Developer |");
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
