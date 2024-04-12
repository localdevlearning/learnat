package com.javadoubts.core.linkrewriter;

import com.adobe.cq.xf.ExperienceFragmentLinkRewriterProvider;
import com.adobe.cq.xf.ExperienceFragmentVariation;
import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = {ExperienceFragmentLinkRewriterProvider.class}, immediate = true)
@ServiceDescription("XF to Target link rewriter")
@Designate(ocd = GeneralLinkRewriter.XFLinkRewriterConfig.class)
public class GeneralLinkRewriter implements ExperienceFragmentLinkRewriterProvider {
  private static final Logger log = LoggerFactory.getLogger(GeneralLinkRewriter.class);
  
  public String rewriteLink(String link, String tag, String attribute) {
    log.info("Rewriting link - Original: {}, Tag: {}, Attribute: {}", new Object[] { link, tag, attribute });
    return link;
  }
  
  public boolean shouldRewrite(ExperienceFragmentVariation experienceFragment) {
    boolean shouldRewrite = StringUtils.startsWith(experienceFragment.getPath(), "/content/experience-fragments/wknd/language-masters/en");
    log.info("Should rewrite for path {}: {}", experienceFragment.getPath(), Boolean.valueOf(shouldRewrite));
    return shouldRewrite;
  }
  
  public int getPriority() {
    return 0;
  }
  
  @ObjectClassDefinition(name = "XF Link Rewriter Config")
  public static @interface XFLinkRewriterConfig {}
}
