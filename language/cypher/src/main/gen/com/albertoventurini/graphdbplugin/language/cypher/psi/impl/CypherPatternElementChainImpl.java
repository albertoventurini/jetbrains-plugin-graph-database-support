/**
 * Copied and adapted from plugin
 * <a href="https://github.com/neueda/jetbrains-plugin-graph-database-support">Graph Database Support</a>
 * by Neueda Technologies, Ltd.
 * Modified by Alberto Venturini, 2022
 */
// This is a generated file. Not intended for manual editing.
package com.albertoventurini.graphdbplugin.language.cypher.psi.impl;

import com.albertoventurini.graphdbplugin.language.cypher.psi.CypherNodePattern;
import com.albertoventurini.graphdbplugin.language.cypher.psi.CypherPatternElementChain;
import com.albertoventurini.graphdbplugin.language.cypher.psi.CypherRelationshipPattern;
import com.albertoventurini.graphdbplugin.language.cypher.psi.CypherVisitor;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;

public class CypherPatternElementChainImpl extends ASTWrapperPsiElement implements CypherPatternElementChain {

  public CypherPatternElementChainImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CypherVisitor visitor) {
    visitor.visitPatternElementChain(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CypherVisitor) accept((CypherVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CypherNodePattern getNodePattern() {
    return findChildByClass(CypherNodePattern.class);
  }

  @Override
  @NotNull
  public CypherRelationshipPattern getRelationshipPattern() {
    return findNotNullChildByClass(CypherRelationshipPattern.class);
  }

}
