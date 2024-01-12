package study.data.jpa.repository;

public interface NestedClosedProjects {

    String getUsername();
    TeamInfo getTeam();

    interface TeamInfo {
        String getName();
    }

}
