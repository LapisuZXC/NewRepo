package LR8;
import java.io.File;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;


public class DataManager {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();
        dataManager.registerDataProcessor(new FilterDataProcessor());
        dataManager.registerDataProcessor(new TransformDataProcessor());
        dataManager.registerDataProcessor(new AggregateDataProcessor());

        dataManager.loadData("source.txt");
        dataManager.processData();
        dataManager.saveData("destination.txt");
    }
    private List<Object> dataProcessors = new ArrayList<>();
    private List<Object> processedData = new ArrayList<>();

    public void registerDataProcessor(Object processor) {
        dataProcessors.add(processor);
    }

    
    
    public void processData() {
        ExecutorService executorService = Executors.newFixedThreadPool(dataProcessors.size());

        List<CompletableFuture<Void>> futures = dataProcessors.stream()
                .map(processor -> CompletableFuture.runAsync(() -> processDataProcessor(processor), executorService))
                .collect(Collectors.toList());

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        executorService.shutdown();
    }

    private void processDataProcessor(Object processor) {
        
    }

     private String getClassFolderPath() {
        String classFilePath = getClass().getResource(getClass().getSimpleName() + ".class").getPath();
        String classFolderPath = new File(classFilePath).getParent();
        return classFolderPath;
    }

    public void loadData(String source) {
        String classFolderPath = getClassFolderPath();
        Path sourcePath = Path.of(classFolderPath, source);
    }

    public void saveData(String destination) {
        String classFolderPath = getClassFolderPath();
        Path sourcePath = Path.of(classFolderPath, destination);

    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface DataProcessor {
}

class FilterDataProcessor {
    @DataProcessor
    public void filterData() {
        
    }
}

class TransformDataProcessor {
    @DataProcessor
    public void transformData() {
       
    }
}

class AggregateDataProcessor {
    @DataProcessor
    public void aggregateData() {
        
    }
}


    

