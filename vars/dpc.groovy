def callDpcTool(Map args) {
    def toolName = args.toolName
    def additionalArguments = args.additionalArguments
    def reportPattern = args.reportPattern

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
