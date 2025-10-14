package tony.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable; // Marks the entity as immutable

@Entity
@Table(name = "SESSIONS", schema = "INFORMATION_SCHEMA")
@Immutable // This annotation from Hibernate marks the entity as read-only.
public class H2Session {

    @Id // The SESSION_ID is a natural, read-only key.
    @Column(name = "SESSION_ID")
    private Long sessionId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "SESSION_START")
    private String sessionStart;

//    @Column(name = "IS_ADMIN")
//    private boolean isAdmin;

//    @Column(name = "CLIENT_IP")
//    private String clientIp;

//    @Column(name = "CLIENT_AGENT")
//    private String clientAgent;

//    @Column(name = "DATABASE")
//    private String database;

    // A protected default constructor is required by JPA.
    protected H2Session() {
    }

    // --- Getters only, no setters since this is a read-only entity ---
    public Long getSessionId() {
        return sessionId;
    }

    public String getUserName() {
        return userName;
    }

    public String getSessionStart() {
        return sessionStart;
    }

//    public boolean isAdmin() {
//        return isAdmin;
//    }

//    public String getClientIp() {
//        return clientIp;
//    }

//    public String getClientAgent() {
//        return clientAgent;
//    }

//    public String getDatabase() {
//        return database;
//    }

    @Override
    public String toString() {
        return String.format("H2Session[sessionId=%d, userName='%s']", sessionId, userName);
    }
}
