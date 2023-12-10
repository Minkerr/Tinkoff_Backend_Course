package edu.hw9;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class DirectorySearcher {
    private List<String> directoriesWithNFiles;
    private String strPath;

    public DirectorySearcher(String str) {
        this.directoriesWithNFiles = new ArrayList<>();
        this.strPath = str;
    }

    public class DirectoriesFinder extends RecursiveTask<Void> {
        private File file;
        private int n;

        public DirectoriesFinder(File file, int n) {
            this.file = file;
            this.n = n;
        }

        @Override
        protected Void compute() {
            if (Objects.requireNonNull(file.listFiles((f) -> !f.isDirectory())).length > n) {
                directoriesWithNFiles.add(file.getPath());
            }
            File[] directories = file.listFiles(File::isDirectory);
            for (var f : directories) {
                DirectoriesFinder newFounder = new DirectoriesFinder(f, n);
                newFounder.fork();
                newFounder.join();
            }
            return null;
        }
    }

    public void findDirectories(File file, int n) {
        DirectoriesFinder finder = new DirectoriesFinder(file, n);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(finder);
    }

    public List<String> getDirectoriesWithNFiles() {
        return directoriesWithNFiles;
    }

    public String getStrPath() {
        return strPath;
    }
}
