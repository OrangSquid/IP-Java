import java.util.Scanner;
import java.io.*;

public class Main {
    // Constant messages
    private static final String INVALID_COMMAND_MSG = "Comando invalido";
    private static final String BURRIED_TREASURE_MSG = "Riqueza enterrada: %d\n";
    private static final String CLASSIFICATION_MSG = "%s: %d pts; %d descl.; %d com lic.\n";
    private static final String INVALID_TEAM_MSG = "Equipa invalida";
    private static final String MVP_MSG = "Estrela de %s: %s\n";
    private static final String ALL_TEAMS_OUT_MSG = "Todas as equipas foram expulsas.";
    private static final String TREASURES_NOT_FOUND_MSG = "Ainda havia tesouros por descobrir...";
    private static final String TREASURES_FOUND_MSG = "Todos os tesouros foram descobertos!";
    private static final String INVALID_JUMP_MSG = "Salto invalido";
    private static final String TEAM_OUT_MSG = "%s foi expulsa\n";
    // Constant commands
    private static final String COMMAND_EXIT = "sair";
    private static final String COMMAND_WEALTH = "riqueza";
    private static final String COMMAND_TERRAIN = "terreno";
    private static final String COMMAND_CLASSIFICATION = "classificacao";
    private static final String COMMAND_STAR = "estrela";
    private static final String COMMAND_EXCAVATION = "escavacao";
    // Terrain command constants
    private static final String NO_TREASURE = "-";
    private static final String YES_TREASURE = "*";
    // Excavation command constants
    private static final int TEAM_OUT = 1;
    private static final int TEAM_INVALID = 2;
    private static final int INVALID_JUMP = 0;

    public static void main(String[] args) throws FileNotFoundException {
        // Create both Scanners for keyboard and teams.txt file
        Scanner sc = new Scanner(System.in);
        Scanner fileReader = new Scanner(new FileReader("teams.txt"));

        // Read the information for the terrain from the keyboard
        int nLines = sc.nextInt();
        int nColumns = sc.nextInt();

        int[][] terrain = new int[nLines][nColumns];

        for (int i = 0; i < nLines; i++) {
            for (int j = 0; j < nColumns; j++) {
                terrain[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        // Create ContestSystem to manage the logic behind the contest
        ContestSystem cs = new ContestSystem(terrain);

        addTeams(sc, fileReader, cs);
        fileReader.close();

        commandInterpreter(sc, cs);
        sc.close();
    }

    /**
     * Reads from the keyboard what teams to include from teams.txt file and adds
     * them to the provided ContextSystem
     * 
     * @param sc         Keyboard Scanner
     * @param fileReader teams.txt file reader
     * @param cs         ContestSystem
     * @pre {@code sc != null && fileReader != null && cs != null}
     */
    private static void addTeams(Scanner sc, Scanner fileReader, ContestSystem cs) {
        int nQualifiedTeams = sc.nextInt();
        sc.nextLine();
        int teamFileIndex = 1;

        for (int i = 0; i < nQualifiedTeams; i++) {
            int nTeam = sc.nextInt();
            // Skips over the teams we don't want
            while (teamFileIndex != nTeam) {
                int linesToSkip = fileReader.nextInt() + 2;
                for (int j = 0; j < linesToSkip; j++) {
                    fileReader.nextLine();
                }
                teamFileIndex++;
            }
            // Reads the information from the team we want
            int nTeamMembers = fileReader.nextInt();
            fileReader.nextLine();
            String teamName = fileReader.nextLine();
            String[] teamMembers = new String[nTeamMembers];
            for (int j = 0; j < nTeamMembers; j++) {
                teamMembers[j] = fileReader.nextLine();
            }
            cs.addTeam(teamName, teamMembers);
            teamFileIndex++;
        }
    }

    /**
     * Reads the command from the keyboard and then calls the appropriate
     * method to handle that command
     * 
     * @param sc Keyboard Scanner
     * @param cs ContestSystem
     * @pre {@code sc != null && cs != null}
     */
    private static void commandInterpreter(Scanner sc, ContestSystem cs) {
        String command = "";
        while (!command.equals(COMMAND_EXIT)) {
            command = sc.next();
            switch (command) {
                case COMMAND_WEALTH:
                    wealthCommand(cs);
                    break;
                case COMMAND_TERRAIN:
                    terrainCommand(cs);
                    break;
                case COMMAND_CLASSIFICATION:
                    classificationCommand(cs);
                    break;
                case COMMAND_STAR:
                    starCommand(sc, cs);
                    break;
                case COMMAND_EXCAVATION:
                    excavationCommand(sc, cs);
                    break;
                case COMMAND_EXIT:
                    exitCommand(cs);
                    break;
                default:
                    System.out.println(INVALID_COMMAND_MSG);
                    sc.nextLine();
            }
        }
    }

    /**
     * Handles the "riqueza" command
     * 
     * @param cs ContestSystem object
     * @pre {@code cs != null}
     */
    private static void wealthCommand(ContestSystem cs) {
        System.out.printf(BURRIED_TREASURE_MSG, cs.getWealth());
    }

    /**
     * Handles the "terreno" command
     * 
     * @param cs ContestSystem obejct
     * @pre {@code cs != null}
     */
    private static void terrainCommand(ContestSystem cs) {
        boolean[][] terrainStatus = cs.getTerrainStatus();
        for (int i = 0; i < terrainStatus.length; i++) {
            for (int j = 0; j < terrainStatus[0].length; j++) {
                if (terrainStatus[i][j]) {
                    System.out.print(YES_TREASURE);
                } else {
                    System.out.print(NO_TREASURE);
                }
            }
            System.out.println();
        }
    }

    /**
     * Handles the "classificacao" command
     * 
     * @param cs Contest System object
     * @pre {@code cs != null}
     */
    private static void classificationCommand(ContestSystem cs) {
        if (cs.allTeamsDisqualified()) {
            System.out.println(ALL_TEAMS_OUT_MSG);
        } else {
            ClassificationIterator it = cs.getClassificationIterator();

            while (it.hasNext()) {
                Team team = it.next();
                if (!team.allMembersDisqualified())
                    System.out.printf(CLASSIFICATION_MSG, team.getTeamName(),
                            team.getTeamMerit(), team.getNMemDisqualified(),
                            team.getNMemQualified());
            }
        }
    }

    /**
     * Handles the "estrela" command
     * 
     * @param sc Keyboard Scanner object
     * @param cs ContestSystem object
     * @pre {@code cs != null && sc != null}
     */
    private static void starCommand(Scanner sc, ContestSystem cs) {
        String teamName = sc.nextLine().trim();
        String starMember = cs.getStarMember(teamName);

        if (starMember.equals("")) {
            System.out.println(INVALID_TEAM_MSG);
        } else {
            System.out.printf(MVP_MSG, teamName, starMember);
        }
    }

    /**
     * Handles the "escavacao" command
     * 
     * @param sc Contest System object
     * @param cs Keyboard Scanner object
     */
    private static void excavationCommand(Scanner sc, ContestSystem cs) {
        int jumpX = sc.nextInt();
        int jumpY = sc.nextInt();
        String teamName = sc.nextLine().trim();
        if (jumpX == INVALID_JUMP && jumpY == INVALID_JUMP) {
            System.out.println(INVALID_JUMP_MSG);
        } else {
            int status = cs.dig(jumpX, jumpY, teamName);
            if (status == TEAM_OUT) {
                System.out.printf(TEAM_OUT_MSG, teamName);
            } else if (status == TEAM_INVALID) {
                System.out.println(INVALID_TEAM_MSG);
            }
        }
    }

    /**
     * Handles the "sair" command
     * 
     * @param cs Contest System object
     * @pre {@code cs != null}
     */
    private static void exitCommand(ContestSystem cs) {
        if (cs.allTeamsDisqualified()) {
            System.out.println(ALL_TEAMS_OUT_MSG);
        } else if (cs.getWealth() != 0) {
            System.out.println(TREASURES_NOT_FOUND_MSG);
        } else if (cs.getWealth() == 0) {
            System.out.println(TREASURES_FOUND_MSG);
        }
    }
}