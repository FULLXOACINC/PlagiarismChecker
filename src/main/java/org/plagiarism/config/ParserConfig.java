package org.plagiarism.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParserConfig {
    private List<AdditionalFileExtensionConfig> additionalFileExtensions;
}
