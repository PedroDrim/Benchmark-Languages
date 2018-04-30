# Importando bibioteca para construção de gráficos
require(ggplot2)

# Função para analisar os resultados dos experimentos
plotData = function(result, name_prefix) {
  
  pd = position_dodge(0.1) # move them .05 to the left and right
  
  for(lang in unique(result$lang)) {
  
    lang_res = result[result$lang == lang,]
    
    p_name = sprintf("./output/%s_%s.png", name_prefix, lang)

    p = ggplot(lang_res, aes(x=Tamanho, y=mean, colour=lang, group=lang)) + 
      geom_errorbar(aes(ymin=mean-sd, ymax=mean+sd), colour="black", width=.1, position=pd) +
      geom_line(position=pd) +
      geom_smooth(method = "lm", se = FALSE, col = "grey") + 
      geom_point(position=pd, size=3, shape=21, fill="white") + # 21 is filled circle
      xlab("Quantidade de elementos") +
      ylab("Tempo (ms)") +
      ggtitle("Tempo necessário para instanciar classes simples") +
      theme_bw()       

    png(p_name)
    plot(p)
    dev.off()
  }
}
