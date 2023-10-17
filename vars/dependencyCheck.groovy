// dpc.groovy
def call(Map config) {
    def toolName = config.toolName
    def additionalArguments = config.additionalArguments
    def reportPattern = config.reportPattern

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
