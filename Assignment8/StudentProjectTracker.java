import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class StudentProjectTracker {
    private static class Project {
        private String name;
        private int daysToComplete;
        private boolean completedOnTime;

        public Project(String name, int daysToComplete, boolean completedOnTime) {
            this.name = name;
            this.daysToComplete = daysToComplete;
            this.completedOnTime = completedOnTime;
        }

        public String getName() {
            return name;
        }

        public int getDaysToComplete() {
            return daysToComplete;
        }

        public boolean isCompletedOnTime() {
            return completedOnTime;
        }
    }

    private static class Student {
        private String name;
        private List<Project> projects;

        public Student(String name) {
            this.name = name;
            this.projects = new ArrayList<>();
        }

        public void addProject(Project project) {
            projects.add(project);
        }

        public List<Project> getProjects() {
            return projects;
        }

        public String getName() {
            return name;
        }

        public double averageCompletionTime() {
            double totalDays = 0;
            for (Project project : projects) {
                totalDays += project.getDaysToComplete();
            }
            return totalDays / projects.size();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student name: ");
            String studentName = scanner.nextLine();

            Student student = new Student(studentName);

            System.out.print("Enter the number of projects for " + studentName + ": ");
            int numProjects = scanner.nextInt();
            scanner.nextLine(); 

            for (int j = 0; j < numProjects; j++) {
                System.out.print("Enter project name: ");
                String projectName = scanner.nextLine();

                System.out.print("Enter days to complete project: ");
                int daysToComplete = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Was the project completed on time? (true/false): ");
                boolean completedOnTime = scanner.nextBoolean();
                scanner.nextLine(); 

                student.addProject(new Project(projectName, daysToComplete, completedOnTime));
            }

            students.add(student);
        }

       
        int onTimeCount = 0;
        int lateCount = 0;
        int earlyCount = 0;

        for (Student student : students) {
            for (Project project : student.getProjects()) {
                if (project.isCompletedOnTime()) {
                    onTimeCount++;
                } else if (project.getDaysToComplete() > 0) {
                    lateCount++;
                } else {
                    earlyCount++;
                }
            }
            System.out.println("Average completion time for " + student.getName() + ": " + student.averageCompletionTime());
        }

        System.out.println("Projects completed on time: " + onTimeCount);
        System.out.println("Projects completed late: " + lateCount);
        System.out.println("Projects completed early: " + earlyCount);

        scanner.close();
    }
}
