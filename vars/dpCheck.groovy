// def call(toolName, additionalArguments, reportPattern){
//     def additionalArgs = additionalArguments.trim()
//     sh """
//         ${toolName} \\
//         ${additionalArgs} \\
//         --odcInstallation=${toolName}
//     """
//     step([
//         $class: 'DependencyCheckPublisher',
//         pattern: reportPattern
//     ])

// }

def callCustomFunction(params) {
    def toolName = params.toolName
    def additionalArguments = params.additionalArguments
    def reportPattern = params.reportPattern

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