package edu.hw9;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class DirectorySearcher {
    private List<String> directoriesWithNFiles;
    private List<String> filesWithCondition;
    private String strPath;

    public DirectorySearcher(String str) {
        this.directoriesWithNFiles = new ArrayList<>();
        this.filesWithCondition = new ArrayList<>();
        this.strPath = str;
    }

    public List<String> getDirectoriesWithNFiles() {
        return directoriesWithNFiles;
    }

    public List<String> getFilesWithCondition() {
        return filesWithCondition;
    }

    public String getStrPath() {
        return strPath;
    }

    public void findDirectories(File file, int n) {
        DirectoriesFinder finder = new DirectoriesFinder(file, n);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(finder);
    }

    public void findFiles(File file, int size, String ext) {
        FileFinder finder = new FileFinder(file, size, ext);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(finder);
    }

    public class FileFinder extends RecursiveTask<Void> {
        private File file;
        private int size;
        private String extinction;

        public FileFinder(File file, int size, String extinction) {
            this.file = file;
            this.size = size;
            this.extinction = extinction;
        }

        private String getFileExtension(File file) {
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(".");
            return name.substring(lastIndexOf + 1);
        }

        @Override
        protected Void compute() {
            File[] files = file.listFiles((f) -> !f.isDirectory());
            for (var f : files) {
                if (f != null) {
                    String thisExt = getFileExtension(f);
                    long thisSize = f.length();
                    if (thisSize > size && thisExt.equals(extinction)) {
                        filesWithCondition.add(f.getPath());
                    }
                }
            }
            File[] directories = file.listFiles(File::isDirectory);
            for (var f : directories) {
                FileFinder newFounder = new FileFinder(f, size, extinction);
                newFounder.fork();
                newFounder.join();
            }
            return null;
        }
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
}
