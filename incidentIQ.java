import java.util.Scanner;

class Main {

    static int readNumber(Scanner sc, String message) {
        int number;

        while (true) {
            System.out.print(message);

            if (sc.hasNextInt()) {
                number = sc.nextInt();
                sc.nextLine();
                return number;
            } else {
                System.out.println("Invalid input! Enter a number.");
                sc.nextLine();
            }
        }
    }

    static String getImpact(int impact) {
        switch (impact) {
            case 1:
                return "Minimal";
            case 2:
                return "Low";
            case 3:
                return "High";
            case 4:
                return "Critical";
            default:
                return "Invalid";
        }
    }

    static String getUrgency(int urgency) {
        switch (urgency) {
            case 1:
                return "Low";
            case 2:
                return "Moderate";
            case 3:
                return "High";
            case 4:
                return "Immediate";
            default:
                return "Invalid";
        }
    }
	
    static int calculateScore(int impact, int urgency) {
        return (impact * 2) + ( urgency * 2);
    }

    static String getPriority(int score) {
        if (score >= 13) {
            return "P1 - Critical";
        } else if (score >= 9) {
            return "P2 - High";
        } else if (score >= 5) {
            return "P3 - Medium";
        } else {
            return "P4 - Low";
        }
    }

    static String getResponseTarget(int score) {
        if (score >= 13) {
            return "1 hour";
        } else if (score >= 9) {
            return "4 hours";
        } else if (score >= 5) {
            return "8 hours";
        } else {
            return "24 hours";
        }
    }

    static boolean validService(String service) {
        return service.equalsIgnoreCase("Network")
            || service.equalsIgnoreCase("Application")
            || service.equalsIgnoreCase("Hardware")
            || service.equalsIgnoreCase("Access")
            || service.equalsIgnoreCase("Other");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalIncidents = 0;
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;

        int majorIncidents = 0;
        int totalAffectedUsers = 0;

        int impact;
        int urgency;
        int affectedUsers;
        int priorityScore;

        double averageUsers;
        double p1p2Percentage;

        String title;
        String service;
        String description;
        String priority;
        String choice;

        System.out.println("");
        System.out.println("                 INCIDENTIQ");
        System.out.println("          IT INCIDENT TRIAGE CONSOLE");
        System.out.println("==================================================");

        System.out.println("\nWelcome to IncidentIQ!");

        System.out.print("\nRegister a new incident? (yes/no): ");
        choice = sc.nextLine().trim();

        while (choice.equalsIgnoreCase("yes")) {

            totalIncidents++;

            System.out.println("\n ");
            System.out.println("                  INCIDENT 00" + totalIncidents);
            System.out.println("--------------------------------------------------");

            
            do {
                System.out.print("\nEnter incident title: ");

                title = sc.nextLine();

                if (title.isBlank()) {
                    System.out.println("Title cannot be blank!");
                }

                title = title.trim();

            } while (title.isEmpty());

          
            do {
                System.out.print("Enter affected service "
                    + "(Network/Application/Hardware/Access/Other): ");

                service = sc.nextLine().trim();

                if (service.isEmpty() || !validService(service)) {
                    System.out.println("Invalid service! Try again.");
                }

            } while (service.isEmpty() || !validService(service));

            
            do {
                System.out.print("Enter incident description: ");

                description = sc.nextLine();

                if (description.isBlank()) {
                    System.out.println("Description cannot be blank!");
                }

                description = description.trim();

            } while (description.isEmpty());

            
            do {
                affectedUsers = readNumber(sc,
                    "Enter number of affected users: ");

                if (affectedUsers < 0) {
                    System.out.println("Enter a valid number!");
                }

            } while (affectedUsers <= 0);

          
            do {
                impact = readNumber(sc,
                    "\nEnter impact level (1-4): ");

                if (impact < 1 || impact > 4) {
                    System.out.println("Impact must be between 1 and 4.");
                }

            } while (impact < 1 || impact > 4);

            
            do {
                urgency = readNumber(sc,
                    "Enter urgency level (1-4): ");

                if (urgency < 1 || urgency > 4) {
                    System.out.println("Urgency must be between 1 and 4.");
                }

            } while (urgency < 1 || urgency > 4);

            // Calculation
            priorityScore = calculateScore(impact, urgency);

            priority = getPriority(priorityScore);

            totalAffectedUsers += affectedUsers;

            // Priority counting
            if (priorityScore >= 13) {
                p1++;
            } else if (priorityScore >= 9) {
                p2++;
            } else if (priorityScore >= 5) {
                p3++;
            } else {
                p4++;
            }

            // Major incident condition
            boolean major = impact == 4 && affectedUsers >= 50;

            if (major) {
                majorIncidents++;
            }

            // Incident report
            System.out.println("                                                   ");
            System.out.println("                INCIDENT REPORT");
            System.out.println("--------------------------------------------------");

            System.out.println("Incident ID       : INC-00" + totalIncidents);
            System.out.println("Title             : " + title);
            System.out.println("Service           : " + service);
            System.out.println("Description       : " + description);
            System.out.println("Affected Users    : " + affectedUsers);
            System.out.println("Impact            : " + impact
                + " - " + getImpact(impact));
            System.out.println("Urgency           : " + urgency
                + " - " + getUrgency(urgency));

            System.out.println("\nPriority Score    : " + priorityScore);
            System.out.println("Priority          : " + priority);
            System.out.println("Response Target   : "
                + getResponseTarget(priorityScore));

            if (major) {
                System.out.println("\nMAJOR INCIDENT ALERT!");
                System.out.println("Reason: Critical impact affecting at least 50 users.");
            } else {
                System.out.println("\nMajor Incident    : No");
            }

            System.out.println("\n--------------------------------------------------");

            System.out.print("\nRegister another incident? (yes/no): ");
            choice = sc.nextLine().trim();

     
            while (!choice.equalsIgnoreCase("yes")
                    && !choice.equalsIgnoreCase("no")) {

                System.out.println("Please enter yes or no.");
                System.out.print("Register another incident? (yes/no): ");
                choice = sc.nextLine().trim();
            }
        }

     
        if (totalIncidents > 0) {

            averageUsers = (double) totalAffectedUsers / totalIncidents;

            p1p2Percentage =
                (double) (p1 + p2) / totalIncidents * 100;

            System.out.println("");
            System.out.println("              OPERATIONAL SUMMARY");
            System.out.println("");

            System.out.println("Total Incidents Registered : " + totalIncidents);

            System.out.println("\nPriority Distribution:");
            System.out.println("P1 - Critical              : " + p1);
            System.out.println("P2 - High                  : " + p2);
            System.out.println("P3 - Medium                : " + p3);
            System.out.println("P4 - Low                   : " + p4);

            System.out.println("\nMajor Incidents            : " + majorIncidents);

            System.out.println("\nTotal Affected Users       : " + totalAffectedUsers);
            System.out.println("Average Affected Users     : " + averageUsers);

            System.out.println("P1/P2 Incident Percentage  : "
                + p1p2Percentage + "%");

        } else {
            System.out.println("\nNo incidents were registered.");
        }

        System.out.println("\n==================================================");
        System.out.println("        INCIDENTIQ SESSION COMPLETED");
        System.out.println("==================================================");

        sc.close();
    }
}