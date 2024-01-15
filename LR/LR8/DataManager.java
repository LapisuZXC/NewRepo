package LR8;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.lang.reflect.Method;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface DataProcessor {
}

public class DataManager {
    private LinkedList<Object> processors;
    private ExecutorService service;
    private HashMap<String, Integer> data;
    private StringBuilder outputData;

    public DataManager() {
        processors = new LinkedList<>();
        service = Executors.newFixedThreadPool(10);
        data = new HashMap<>();
        outputData = new StringBuilder();
    }

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) {
        File file = new File(source);
        try (FileReader reader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] dataSet = line.split(" ");
                data.put(dataSet[0], Integer.parseInt(dataSet[1]));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void processData() {
        List<CompletableFuture<String>> futures = new ArrayList<>();
        ArrayList<Integer> indexes = new ArrayList<>();
        int i = 0;
        int j = 0;
        for (Object processor : processors) {
            for (Method method : processor.getClass().getMethods()) {
                if (method.getAnnotation(DataProcessor.class) != null) {
                    indexes.add(0);
                    futures.add(CompletableFuture.supplyAsync(() -> {
                        try {
                            return (String) method.invoke(processor, data);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            return "";
                        }
                    }, service));
                    indexes.set(i, futures.size());
                    i++;
                }
            }
        }
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
        allFutures.join();
        for (CompletableFuture<String> f : futures) {
            try {
                outputData.append(f.get());
                j++;
                for (int index : indexes) {
                    if (j == index) {
                        outputData.append("\n");
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        service.shutdown();
    }

    public void saveData(String outputFile) {
        File file = new File(outputFile);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(outputData.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

class ValueSort {
    @DataProcessor
    public String valueSort(HashMap<String, Integer> data) {
        List<Map.Entry<String, Integer>> list = data.entrySet().stream().sorted((x, y) -> {
            return x.getValue().compareTo(y.getValue());
        }).toList();
        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Integer> entry : list) {
            output.append(entry.getKey());
            output.append(" ");
            output.append(entry.getValue().toString());
            output.append("\n");
        }
        return output.toString();
    }
}


class MoreThanTen {
    @DataProcessor
    public String moreThanTen(HashMap<String, Integer> data) {
        List<Map.Entry<String, Integer>> list = data.entrySet().stream().filter((x) -> x.getValue() > 10).toList();
        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Integer> entry : list) {
            output.append(entry.getKey());
            output.append(" ");
            output.append(entry.getValue().toString());
            output.append("\n");
        }
        return output.toString();
    }
}
class NameSort {
    @DataProcessor
    public String nameSort(HashMap<String, Integer> data) {
        List<Map.Entry<String, Integer>> list = data.entrySet().stream().sorted((x, y) -> {
            return x.getKey().compareTo(y.getKey());
        }).toList();
        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Integer> entry : list) {
            output.append(entry.getKey());
            output.append(" ");
            output.append(entry.getValue().toString());
            output.append("\n");
        }
        return output.toString();
    }
}