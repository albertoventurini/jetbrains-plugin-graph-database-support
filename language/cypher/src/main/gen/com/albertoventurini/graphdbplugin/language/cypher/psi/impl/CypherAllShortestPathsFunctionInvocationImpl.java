/**
 * Copied and adapted from plugin
 * <a href="https://github.com/neueda/jetbrains-plugin-graph-database-support">Graph Database Support</a>
 * by Neueda Technologies, Ltd.
 * Modified by Alberto Venturini, 2022
 */
// This is a generated file. Not intended for manual editing.
package com.albertoventurini.graphdbplugin.language.cypher.psi.impl;

import com.albertoventurini.graphdbplugin.language.cypher.psi.CypherAllShortestPathsFunctionInvocation;
import com.albertoventurini.graphdbplugin.language.cypher.psi.CypherPatternElement;
import com.albertoventurini.graphdbplugin.language.cypher.psi.CypherTypes;
import com.albertoventurini.graphdbplugin.language.cypher.psi.CypherVisitor;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;

public class CypherAllShortestPathsFunctionInvocationImpl extends ASTWrapperPsiElement implements CypherAllShortestPathsFunctionInvocation {

  public CypherAllShortestPathsFunctionInvocationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CypherVisitor visitor) {
    visitor.visitAllShortestPathsFunctionInvocation(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CypherVisitor) accept((CypherVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public CypherPatternElement getPatternElement() {
    return findNotNullChildByClass(CypherPatternElement.class);
  }

  @Override
  @NotNull
  public PsiElement getKAllshortestpaths() {
    return findNotNullChildByType(CypherTypes.K_ALLSHORTESTPATHS);
  }

}
