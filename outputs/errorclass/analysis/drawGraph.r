require(ggplot2)

drawScatter = function(dt, meanCol, sdCol, variable) {
  
  pd = position_dodge(0.1)
  p = ggplot(dt, aes(x=line, y=dt[meanCol], colour=lang, group=lang)) + 
    geom_errorbar(aes(ymin=dt[meanCol]-dt[sdCol], ymax=dt[meanCol]+dt[sdCol]), colour="black", width=.1, position=pd) +
    geom_line(position=pd) +
    geom_point(position=pd, size=3, shape=21, fill="white") + # 21 is filled circle
    xlab("Line ammount") +
    ylab(sprintf("%s Time (ms)", variable)) +
    ggtitle(sprintf("Analysis for %s in %s",variable, unique(r$lang))) +
    expand_limits(y=0) +                        # Expand y range
    theme_bw()
  
  return(p)
}

r = read.csv("../output/LanguageResult.csv", sep = ",")

for(i in unique(r$lang)) {
  rx = r[r$lang == i,]  
  gmean = grep(".mean" , names(rx))
  gsd = grep(".sd", names(rx))
  
  mean.name = names(rx)[gmean]
  sd.name = names(rx)[gsd]
  
  for(j in 1:length(sd.name)) {
    
    n = strsplit(sd.name[j], split = "\\.")[[1]][1]
    pl = drawScatter(rx, mean.name[j], sd.name[j], sprintf("%s data", n))  
    
    png(filename = sprintf("../output/plots/%s_%s.png", i, n))
    plot(pl)
    dev.off()
  }
  
}
