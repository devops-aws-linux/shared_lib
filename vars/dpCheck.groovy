def call(toolName, additionalArguments, reportPattern){
    def additionalArgs = additionalArguments.trim()
    sh """
        ${toolName} \\
        ${additionalArgs} \\
        --odcInstallation=${toolName}
    """
    step([
        $class: 'DependencyCheckPublisher',
        pattern: reportPattern
    ])

}