package org.plagiarism.parser.reader.file;

import org.plagiarism.config.AdditionalFileExtensionConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeReaderFactory {
    private static final DefaultReader DEFAULT = new DefaultReader();
    private final Map<String, CodeReader> readerMap;
    private final List<AdditionalFileExtensionConfig> additionalFileExtensions;

    public CodeReaderFactory(List<AdditionalFileExtensionConfig> additionalFileExtensions) {
        readerMap = new HashMap<>();
        readerMap.put("py", new PythonReader());
        readerMap.put("java", new JavaReader());
        readerMap.put("c", new CppReader());
        readerMap.put("js", new JsReader());
        readerMap.put("cs", new CSharpReader());
        readerMap.put("ipynb", new IpynbReader());
        this.additionalFileExtensions = additionalFileExtensions;
    }


    public CodeReader findCodeReader(String fileExtension) {
        if (readerMap.containsKey(fileExtension)) {
            return readerMap.get(fileExtension);
        }
        for (AdditionalFileExtensionConfig config : additionalFileExtensions) {
            if (config.getExtensions().contains(fileExtension)) {
                return readerMap.getOrDefault(config.getExistingExtension(), DEFAULT);
            }
        }
        return DEFAULT;
    }
}
