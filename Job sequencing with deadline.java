import java.util.Arrays;

class Job {
    int id, deadline, profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JS {
    public static void scheduleJobs(Job[] jobs) {
        int totalProfit = 0;
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        int n = jobs.length;
        boolean[] slots = new boolean[n];
        int[] result = new int[n];
        
        for (Job j : jobs) {
            for (int i = j.deadline - 1; i >= 0; i--) {
                if (!slots[i]) {
                    slots[i] = true;
                    result[i] = j.id;
                    totalProfit += j.profit;
                    break;
                }
            }
        }
        
        System.out.println("Selected Jobs:");
        for (int j : result) {
            if (j != 0) {
                System.out.print(j + " ");
            }
        }
        System.out.println("\nTotal Profit: " + totalProfit);
    }

    public static void main(String args[]) {
        Job[] jobs = {
            new Job(1, 2, 100),
            new Job(2, 1, 19),
            new Job(3, 2, 27),
            new Job(4, 1, 25),
            new Job(5, 3, 15)
        };
        scheduleJobs(jobs);
    }
}


op:
Selected Jobs:
3 1 5 
Total Profit: 142
