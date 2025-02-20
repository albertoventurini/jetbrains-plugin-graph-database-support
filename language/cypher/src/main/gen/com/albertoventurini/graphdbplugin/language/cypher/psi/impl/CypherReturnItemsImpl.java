/**
 * Copied and adapted from plugin
 * <a href="https://github.com/neueda/jetbrains-plugin-graph-database-support">Graph Database Support</a>
 * by Neueda Technologies, Ltd.
 * Modified by Alberto Venturini, 2022
 */
// This is a generated file. Not intended for manual editing.
package com.albertoventurini.graphdbplugin.language.cypher.psi.impl;

import java.util.List;

import com.albertoventurini.graphdbplugin.language.cypher.psi.CypherReturnItem;
import com.albertoventurini.graphdbplugin.language.cypher.psi.CypherReturnItems;
import com.albertoventurini.graphdbplugin.language.cypher.psi.CypherVisitor;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.extapi.psi.ASTWrapperPsiElement;

public class CypherReturnItemsImpl extends ASTWrapperPsiElement implements CypherReturnItems {

  public CypherReturnItemsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CypherVisitor visitor) {
    visitor.visitReturnItems(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CypherVisitor) accept((CypherVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<CypherReturnItem> getReturnItemList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CypherReturnItem.class);
  }

}
