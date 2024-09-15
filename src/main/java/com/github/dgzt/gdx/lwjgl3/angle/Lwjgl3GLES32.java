/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.github.dgzt.gdx.lwjgl3.angle;

import com.badlogic.gdx.graphics.GL32;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengles.GLDebugMessageCallbackI;
import org.lwjgl.opengles.GLES32;
import org.lwjgl.opengles.KHRBlendEquationAdvanced;
import org.lwjgl.system.MemoryUtil;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public class Lwjgl3GLES32 extends Lwjgl3GLES20 implements GL32 {

    private final static ByteBuffer tmpByteBuffer = BufferUtils.newByteBuffer(16);
    private static final PointerBuffer pb = PointerBuffer.allocateDirect(16);

    @Override
    public void glReadBuffer(int mode) {
        GLES32.glReadBuffer(mode);
    }

    @Override
    public void glDrawRangeElements(int mode, int start, int end, int count, int type, Buffer indices) {
        if (indices instanceof ByteBuffer)
            GLES32.glDrawRangeElements(mode, start, end, (ByteBuffer)indices);
        else if (indices instanceof ShortBuffer)
            GLES32.glDrawRangeElements(mode, start, end, (ShortBuffer)indices);
        else if (indices instanceof IntBuffer)
            GLES32.glDrawRangeElements(mode, start, end, (IntBuffer)indices);
        else
            throw new GdxRuntimeException("indices must be byte, short or int buffer");
    }

    @Override
    public void glDrawRangeElements(int mode, int start, int end, int count, int type, int offset) {
        GLES32.glDrawRangeElements(mode, start, end, count, type, offset);
    }

    @Override
    public void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, int offset) {
        GLES32.glTexImage2D(target, level, internalformat, width, height, border, format, type, offset);
    }

    @Override
    public void glTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, Buffer pixels) {
        if (pixels == null)
            GLES32.glTexImage3D(target, level, internalformat, width, height, depth, border, format, type, (ByteBuffer)null);
        else if (pixels instanceof ByteBuffer)
            GLES32.glTexImage3D(target, level, internalformat, width, height, depth, border, format, type, (ByteBuffer)pixels);
        else if (pixels instanceof ShortBuffer)
            GLES32.glTexImage3D(target, level, internalformat, width, height, depth, border, format, type, (ShortBuffer)pixels);
        else if (pixels instanceof IntBuffer)
            GLES32.glTexImage3D(target, level, internalformat, width, height, depth, border, format, type, (IntBuffer)pixels);
        else if (pixels instanceof FloatBuffer)
            GLES32.glTexImage3D(target, level, internalformat, width, height, depth, border, format, type, (FloatBuffer)pixels);
//        else if (pixels instanceof DoubleBuffer)
//            GLES32.glTexImage3D(target, level, internalformat, width, height, depth, border, format, type, (DoubleBuffer)pixels);
        else
            throw new GdxRuntimeException("Can't use " + pixels.getClass().getName()
//                    + " with this method. Use ByteBuffer, ShortBuffer, IntBuffer, FloatBuffer or DoubleBuffer instead. Blame LWJGL");
                    + " with this method. Use ByteBuffer, ShortBuffer, IntBuffer or FloatBuffer instead. Blame LWJGL");
    }

    @Override
    public void glTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, int offset) {
        GLES32.glTexImage3D(target, level, internalformat, width, height, depth, border, format, type, offset);
    }

    @Override
    public void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, int offset) {
        GLES32.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, offset);
    }

    @Override
    public void glTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, Buffer pixels) {
        if (pixels instanceof ByteBuffer)
            GLES32.glTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, (ByteBuffer)pixels);
        else if (pixels instanceof ShortBuffer)
            GLES32.glTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, (ShortBuffer)pixels);
        else if (pixels instanceof IntBuffer)
            GLES32.glTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, (IntBuffer)pixels);
        else if (pixels instanceof FloatBuffer)
            GLES32.glTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, (FloatBuffer)pixels);
//        else if (pixels instanceof DoubleBuffer)
//            GLES32.glTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, (DoubleBuffer)pixels);
        else
            throw new GdxRuntimeException("Can't use " + pixels.getClass().getName()
//                    + " with this method. Use ByteBuffer, ShortBuffer, IntBuffer, FloatBuffer or DoubleBuffer instead. Blame LWJGL");
                    + " with this method. Use ByteBuffer, ShortBuffer, IntBuffer or FloatBuffer instead. Blame LWJGL");
    }

    @Override
    public void glTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, int offset) {
        GLES32.glTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, offset);
    }

    @Override
    public void glCopyTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
        GLES32.glCopyTexSubImage3D(target, level, xoffset, yoffset, zoffset, x, y, width, height);
    }

    @Override
    public void glGenQueries(int n, int[] ids, int offset) {
        for (int i = offset; i < offset + n; i++) {
            ids[i] = GLES32.glGenQueries();
        }
    }

    @Override
    public void glGenQueries(int n, IntBuffer ids) {
        for (int i = 0; i < n; i++) {
            ids.put(GLES32.glGenQueries());
        }
    }

    @Override
    public void glDeleteQueries(int n, int[] ids, int offset) {
        for (int i = offset; i < offset + n; i++) {
            GLES32.glDeleteQueries(ids[i]);
        }
    }

    @Override
    public void glDeleteQueries(int n, IntBuffer ids) {
        for (int i = 0; i < n; i++) {
            GLES32.glDeleteQueries(ids.get());
        }
    }

    @Override
    public boolean glIsQuery(int id) {
        return GLES32.glIsQuery(id);
    }

    @Override
    public void glBeginQuery(int target, int id) {
        GLES32.glBeginQuery(target, id);
    }

    @Override
    public void glEndQuery(int target) {
        GLES32.glEndQuery(target);
    }

    @Override
    public void glGetQueryiv(int target, int pname, IntBuffer params) {
        GLES32.glGetQueryiv(target, pname, params);
    }

    @Override
    public void glGetQueryObjectuiv(int id, int pname, IntBuffer params) {
        GLES32.glGetQueryObjectuiv(id, pname, params);
    }

    @Override
    public boolean glUnmapBuffer(int target) {
        return GLES32.glUnmapBuffer(target);
    }

    @Override
    public Buffer glGetBufferPointerv(int target, int pname) {
        // FIXME glGetBufferPointerv needs a proper translation
        // return GL15.glGetBufferPointer(target, pname);
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void glDrawBuffers(int n, IntBuffer bufs) {
        int limit = bufs.limit();
        ((Buffer)bufs).limit(n);
        GLES32.glDrawBuffers(bufs);
        ((Buffer)bufs).limit(limit);
    }

    @Override
    public void glUniformMatrix2x3fv(int location, int count, boolean transpose, FloatBuffer value) {
        GLES32.glUniformMatrix2x3fv(location, transpose, value);
    }

    @Override
    public void glUniformMatrix3x2fv(int location, int count, boolean transpose, FloatBuffer value) {
        GLES32.glUniformMatrix3x2fv(location, transpose, value);
    }

    @Override
    public void glUniformMatrix2x4fv(int location, int count, boolean transpose, FloatBuffer value) {
        GLES32.glUniformMatrix2x4fv(location, transpose, value);
    }

    @Override
    public void glUniformMatrix4x2fv(int location, int count, boolean transpose, FloatBuffer value) {
        GLES32.glUniformMatrix4x2fv(location, transpose, value);
    }

    @Override
    public void glUniformMatrix3x4fv(int location, int count, boolean transpose, FloatBuffer value) {
        GLES32.glUniformMatrix3x4fv(location, transpose, value);
    }

    @Override
    public void glUniformMatrix4x3fv(int location, int count, boolean transpose, FloatBuffer value) {
        GLES32.glUniformMatrix4x3fv(location, transpose, value);
    }

    @Override
    public void glBlitFramebuffer(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
        GLES32.glBlitFramebuffer(srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
    }

    @Override
    public void glRenderbufferStorageMultisample(int target, int samples, int internalformat, int width, int height) {
        GLES32.glRenderbufferStorageMultisample(target, samples, internalformat, width, height);
    }

    @Override
    public void glFramebufferTextureLayer(int target, int attachment, int texture, int level, int layer) {
        GLES32.glFramebufferTextureLayer(target, attachment, texture, level, layer);
    }

    @Override
    public Buffer glMapBufferRange(int target, int offset, int length, int access) {
        return GLES32.glMapBufferRange(target, offset, length, access, null);
    }

    @Override
    public void glFlushMappedBufferRange(int target, int offset, int length) {
        GLES32.glFlushMappedBufferRange(target, offset, length);
    }

    @Override
    public void glBindVertexArray(int array) {
        GLES32.glBindVertexArray(array);
    }

    @Override
    public void glDeleteVertexArrays(int n, int[] arrays, int offset) {
        for (int i = offset; i < offset + n; i++) {
            GLES32.glDeleteVertexArrays(arrays[i]);
        }
    }

    @Override
    public void glDeleteVertexArrays(int n, IntBuffer arrays) {
        GLES32.glDeleteVertexArrays(arrays);
    }

    @Override
    public void glGenVertexArrays(int n, int[] arrays, int offset) {
        for (int i = offset; i < offset + n; i++) {
            arrays[i] = GLES32.glGenVertexArrays();
        }
    }

    @Override
    public void glGenVertexArrays(int n, IntBuffer arrays) {
        GLES32.glGenVertexArrays(arrays);
    }

    @Override
    public boolean glIsVertexArray(int array) {
        return GLES32.glIsVertexArray(array);
    }

    @Override
    public void glBeginTransformFeedback(int primitiveMode) {
        GLES32.glBeginTransformFeedback(primitiveMode);
    }

    @Override
    public void glEndTransformFeedback() {
        GLES32.glEndTransformFeedback();
    }

    @Override
    public void glBindBufferRange(int target, int index, int buffer, int offset, int size) {
        GLES32.glBindBufferRange(target, index, buffer, offset, size);
    }

    @Override
    public void glBindBufferBase(int target, int index, int buffer) {
        GLES32.glBindBufferBase(target, index, buffer);
    }

    @Override
    public void glTransformFeedbackVaryings(int program, String[] varyings, int bufferMode) {
        GLES32.glTransformFeedbackVaryings(program, varyings, bufferMode);
    }

    @Override
    public void glVertexAttribIPointer(int index, int size, int type, int stride, int offset) {
        GLES32.glVertexAttribIPointer(index, size, type, stride, offset);
    }

    @Override
    public void glGetVertexAttribIiv(int index, int pname, IntBuffer params) {
        GLES32.glGetVertexAttribIiv(index, pname, params);
    }

    @Override
    public void glGetVertexAttribIuiv(int index, int pname, IntBuffer params) {
        GLES32.glGetVertexAttribIuiv(index, pname, params);
    }

    @Override
    public void glVertexAttribI4i(int index, int x, int y, int z, int w) {
        GLES32.glVertexAttribI4i(index, x, y, z, w);
    }

    @Override
    public void glVertexAttribI4ui(int index, int x, int y, int z, int w) {
        GLES32.glVertexAttribI4ui(index, x, y, z, w);
    }

    @Override
    public void glGetUniformuiv(int program, int location, IntBuffer params) {
        GLES32.glGetUniformuiv(program, location, params);
    }

    @Override
    public int glGetFragDataLocation(int program, String name) {
        return GLES32.glGetFragDataLocation(program, name);
    }

    @Override
    public void glUniform1uiv(int location, int count, IntBuffer value) {
        GLES32.glUniform1uiv(location, value);
    }

    @Override
    public void glUniform3uiv(int location, int count, IntBuffer value) {
        GLES32.glUniform3uiv(location, value);
    }

    @Override
    public void glUniform4uiv(int location, int count, IntBuffer value) {
        GLES32.glUniform4uiv(location, value);
    }

    @Override
    public void glClearBufferiv(int buffer, int drawbuffer, IntBuffer value) {
        GLES32.glClearBufferiv(buffer, drawbuffer, value);
    }

    @Override
    public void glClearBufferuiv(int buffer, int drawbuffer, IntBuffer value) {
        GLES32.glClearBufferuiv(buffer, drawbuffer, value);
    }

    @Override
    public void glClearBufferfv(int buffer, int drawbuffer, FloatBuffer value) {
        GLES32.glClearBufferfv(buffer, drawbuffer, value);
    }

    @Override
    public void glClearBufferfi(int buffer, int drawbuffer, float depth, int stencil) {
        GLES32.glClearBufferfi(buffer, drawbuffer, depth, stencil);
    }

    @Override
    public String glGetStringi(int name, int index) {
        return GLES32.glGetStringi(name, index);
    }

    @Override
    public void glCopyBufferSubData(int readTarget, int writeTarget, int readOffset, int writeOffset, int size) {
        GLES32.glCopyBufferSubData(readTarget, writeTarget, readOffset, writeOffset, size);
    }

    @Override
    public void glGetUniformIndices(int program, String[] uniformNames, IntBuffer uniformIndices) {
        // GLES32.glGetUniformIndices(program, uniformNames, uniformIndices);
        // TODDO fix later
        throw new GdxRuntimeException("Unimplemented method");
    }

    @Override
    public void glGetActiveUniformsiv(int program, int uniformCount, IntBuffer uniformIndices, int pname, IntBuffer params) {
        GLES32.glGetActiveUniformsiv(program, uniformIndices, pname, params);
    }

    @Override
    public int glGetUniformBlockIndex(int program, String uniformBlockName) {
        return GLES32.glGetUniformBlockIndex(program, uniformBlockName);
    }

    @Override
    public void glGetActiveUniformBlockiv(int program, int uniformBlockIndex, int pname, IntBuffer params) {
        GLES32.glGetActiveUniformBlockiv(program, uniformBlockIndex, pname, params);
    }

    @Override
    public void glGetActiveUniformBlockName(int program, int uniformBlockIndex, Buffer length, Buffer uniformBlockName) {
        GLES32.glGetActiveUniformBlockName(program, uniformBlockIndex, (IntBuffer)length, (ByteBuffer)uniformBlockName);
    }

    @Override
    public String glGetActiveUniformBlockName(int program, int uniformBlockIndex) {
        return GLES32.glGetActiveUniformBlockName(program, uniformBlockIndex, 1024);
    }

    @Override
    public void glUniformBlockBinding(int program, int uniformBlockIndex, int uniformBlockBinding) {
        GLES32.glUniformBlockBinding(program, uniformBlockIndex, uniformBlockBinding);
    }

    @Override
    public void glDrawArraysInstanced(int mode, int first, int count, int instanceCount) {
        GLES32.glDrawArraysInstanced(mode, first, count, instanceCount);
    }

    @Override
    public void glDrawElementsInstanced(int mode, int count, int type, int indicesOffset, int instanceCount) {
        GLES32.glDrawElementsInstanced(mode, count, type, indicesOffset, instanceCount);
    }

    @Override
    public void glGetInteger64v(int pname, LongBuffer params) {
        GLES32.glGetInteger64v(pname, params);
    }

    @Override
    public void glGetBufferParameteri64v(int target, int pname, LongBuffer params) {
        params.put(GLES32.glGetBufferParameteri64(target, pname));
    }

    @Override
    public void glGenSamplers(int count, int[] samplers, int offset) {
        for (int i = offset; i < offset + count; i++) {
            samplers[i] = GLES32.glGenSamplers();
        }
    }

    @Override
    public void glGenSamplers(int count, IntBuffer samplers) {
        GLES32.glGenSamplers(samplers);
    }

    @Override
    public void glDeleteSamplers(int count, int[] samplers, int offset) {
        for (int i = offset; i < offset + count; i++) {
            GLES32.glDeleteSamplers(samplers[i]);
        }
    }

    @Override
    public void glDeleteSamplers(int count, IntBuffer samplers) {
        GLES32.glDeleteSamplers(samplers);
    }

    @Override
    public boolean glIsSampler(int sampler) {
        return GLES32.glIsSampler(sampler);
    }

    @Override
    public void glBindSampler(int unit, int sampler) {
        GLES32.glBindSampler(unit, sampler);
    }

    @Override
    public void glSamplerParameteri(int sampler, int pname, int param) {
        GLES32.glSamplerParameteri(sampler, pname, param);
    }

    @Override
    public void glSamplerParameteriv(int sampler, int pname, IntBuffer param) {
        GLES32.glSamplerParameteriv(sampler, pname, param);
    }

    @Override
    public void glSamplerParameterf(int sampler, int pname, float param) {
        GLES32.glSamplerParameterf(sampler, pname, param);
    }

    @Override
    public void glSamplerParameterfv(int sampler, int pname, FloatBuffer param) {
        GLES32.glSamplerParameterfv(sampler, pname, param);
    }

    @Override
    public void glGetSamplerParameteriv(int sampler, int pname, IntBuffer params) {
        GLES32.glGetSamplerParameterIiv(sampler, pname, params);
    }

    @Override
    public void glGetSamplerParameterfv(int sampler, int pname, FloatBuffer params) {
        GLES32.glGetSamplerParameterfv(sampler, pname, params);
    }

    @Override
    public void glVertexAttribDivisor(int index, int divisor) {
        GLES32.glVertexAttribDivisor(index, divisor);
    }

    @Override
    public void glBindTransformFeedback(int target, int id) {
        GLES32.glBindTransformFeedback(target, id);
    }

    @Override
    public void glDeleteTransformFeedbacks(int n, int[] ids, int offset) {
        for (int i = offset; i < offset + n; i++) {
            GLES32.glDeleteTransformFeedbacks(ids[i]);
        }
    }

    @Override
    public void glDeleteTransformFeedbacks(int n, IntBuffer ids) {
        GLES32.glDeleteTransformFeedbacks(ids);
    }

    @Override
    public void glGenTransformFeedbacks(int n, int[] ids, int offset) {
        for (int i = offset; i < offset + n; i++) {
            ids[i] = GLES32.glGenTransformFeedbacks();
        }
    }

    @Override
    public void glGenTransformFeedbacks(int n, IntBuffer ids) {
        GLES32.glGenTransformFeedbacks(ids);
    }

    @Override
    public boolean glIsTransformFeedback(int id) {
        return GLES32.glIsTransformFeedback(id);
    }

    @Override
    public void glPauseTransformFeedback() {
        GLES32.glPauseTransformFeedback();
    }

    @Override
    public void glResumeTransformFeedback() {
        GLES32.glResumeTransformFeedback();
    }

    @Override
    public void glProgramParameteri(int program, int pname, int value) {
        GLES32.glProgramParameteri(program, pname, value);
    }

    @Override
    public void glInvalidateFramebuffer(int target, int numAttachments, IntBuffer attachments) {
        GLES32.glInvalidateFramebuffer(target, attachments);
    }

    @Override
    public void glInvalidateSubFramebuffer(int target, int numAttachments, IntBuffer attachments, int x, int y, int width, int height) {
        GLES32.glInvalidateSubFramebuffer(target, attachments, x, y, width, height);
    }

    @Override
    public void glBlendBarrier() {
        // when available, this extension is enabled by default.
        // see https://registry.khronos.org/OpenGL/extensions/KHR/KHR_blend_equation_advanced.txt
        KHRBlendEquationAdvanced.glBlendBarrierKHR();
    }

    @Override
    public void glCopyImageSubData(int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth) {
        GLES32.glCopyImageSubData(srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ,
                srcWidth, srcHeight, srcDepth);
    }

    @Override
    public void glDebugMessageControl(int source, int type, int severity, IntBuffer ids, boolean enabled) {
        GLES32.glDebugMessageControl(source, type, severity, ids, enabled);
    }

    @Override
    public void glDebugMessageInsert(int source, int type, int id, int severity, String buf) {
        GLES32.glDebugMessageInsert(source, type, id, severity, buf);
    }

    @Override
    public void glDebugMessageCallback(DebugProc callback) {
        if (callback != null) {
            GLES32.glDebugMessageCallback(new GLDebugMessageCallbackI() {
                @Override
                public void invoke (int source, int type, int id, int severity, int length, long message, long userParam) {
                    callback.onMessage(source, type, id, severity, MemoryUtil.memUTF8(message, length));
                }
            }, 0);
        } else {
            GLES32.glDebugMessageCallback(null, 0);
        }
    }

    @Override
    public int glGetDebugMessageLog(int count, IntBuffer sources, IntBuffer types, IntBuffer ids, IntBuffer severities, IntBuffer lengths, ByteBuffer messageLog) {
        return GLES32.glGetDebugMessageLog(count, sources, types, ids, severities, lengths, messageLog);
    }

    @Override
    public void glPushDebugGroup(int source, int id, String message) {
        GLES32.glPushDebugGroup(source, id, message);
    }

    @Override
    public void glPopDebugGroup() {
        GLES32.glPopDebugGroup();
    }

    @Override
    public void glObjectLabel(int identifier, int name, String label) {
        GLES32.glObjectLabel(identifier, name, label);
    }

    @Override
    public String glGetObjectLabel(int identifier, int name) {
        return GLES32.glGetObjectLabel(identifier, name);
    }

    @Override
    public long glGetPointerv(int pname) {
        pb.reset();
        GLES32.glGetPointerv(pname, pb);
        return pb.get();
    }

    @Override
    public void glEnablei(int target, int index) {
        GLES32.glEnablei(target, index);
    }

    @Override
    public void glDisablei(int target, int index) {
        GLES32.glDisablei(target, index);
    }

    @Override
    public void glBlendEquationi(int buf, int mode) {
        GLES32.glBlendEquationi(buf, mode);
    }

    @Override
    public void glBlendEquationSeparatei(int buf, int modeRGB, int modeAlpha) {
        GLES32.glBlendEquationSeparatei(buf, modeRGB, modeAlpha);
    }

    @Override
    public void glBlendFunci(int buf, int src, int dst) {
        GLES32.glBlendFunci(buf, src, dst);
    }

    @Override
    public void glBlendFuncSeparatei(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
        GLES32.glBlendFuncSeparatei(buf, srcRGB, dstRGB, srcAlpha, dstAlpha);
    }

    @Override
    public void glColorMaski(int index, boolean r, boolean g, boolean b, boolean a) {
        GLES32.glColorMaski(index, r, g, b, a);
    }

    @Override
    public boolean glIsEnabledi(int target, int index) {
        return GLES32.glIsEnabledi(target, index);
    }

    @Override
    public void glDrawElementsBaseVertex(int mode, int count, int type, Buffer indices, int basevertex) {
        if (indices instanceof ShortBuffer && type == com.badlogic.gdx.graphics.GL32.GL_UNSIGNED_SHORT) {
            ShortBuffer sb = (ShortBuffer)indices;
            int position = sb.position();
            int oldLimit = sb.limit();
            sb.limit(position + count);
            org.lwjgl.opengles.GLES32.glDrawElementsBaseVertex(mode, sb, basevertex);
            sb.limit(oldLimit);
        } else if (indices instanceof ByteBuffer && type == com.badlogic.gdx.graphics.GL32.GL_UNSIGNED_SHORT) {
            ShortBuffer sb = ((ByteBuffer)indices).asShortBuffer();
            int position = sb.position();
            int oldLimit = sb.limit();
            sb.limit(position + count);
            org.lwjgl.opengles.GLES32.glDrawElementsBaseVertex(mode, sb, basevertex);
            sb.limit(oldLimit);
        } else if (indices instanceof ByteBuffer && type == com.badlogic.gdx.graphics.GL32.GL_UNSIGNED_BYTE) {
            ByteBuffer bb = (ByteBuffer)indices;
            int position = bb.position();
            int oldLimit = bb.limit();
            bb.limit(position + count);
            org.lwjgl.opengles.GLES32.glDrawElementsBaseVertex(mode, bb, basevertex);
            bb.limit(oldLimit);
        } else
            throw new GdxRuntimeException(
                    "Can't use " + indices.getClass().getName() + " with this method. Use ShortBuffer or ByteBuffer instead.");
    }

    @Override
    public void glDrawRangeElementsBaseVertex(int mode, int start, int end, int count, int type, Buffer indices, int basevertex) {
        if (indices instanceof ShortBuffer && type == com.badlogic.gdx.graphics.GL32.GL_UNSIGNED_SHORT) {
            ShortBuffer sb = (ShortBuffer)indices;
            int position = sb.position();
            int oldLimit = sb.limit();
            sb.limit(position + count);
            org.lwjgl.opengles.GLES32.glDrawRangeElementsBaseVertex(mode, start, end, sb, basevertex);
            sb.limit(oldLimit);
        } else if (indices instanceof ByteBuffer && type == com.badlogic.gdx.graphics.GL32.GL_UNSIGNED_SHORT) {
            ShortBuffer sb = ((ByteBuffer)indices).asShortBuffer();
            int position = sb.position();
            int oldLimit = sb.limit();
            sb.limit(position + count);
            org.lwjgl.opengles.GLES32.glDrawRangeElementsBaseVertex(mode, start, end, sb, basevertex);
            sb.limit(oldLimit);
        } else if (indices instanceof ByteBuffer && type == com.badlogic.gdx.graphics.GL32.GL_UNSIGNED_BYTE) {
            ByteBuffer bb = (ByteBuffer)indices;
            int position = bb.position();
            int oldLimit = bb.limit();
            bb.limit(position + count);
            org.lwjgl.opengles.GLES32.glDrawRangeElementsBaseVertex(mode, start, end, bb, basevertex);
            bb.limit(oldLimit);
        } else
            throw new GdxRuntimeException(
                    "Can't use " + indices.getClass().getName() + " with this method. Use ShortBuffer or ByteBuffer instead.");
    }

    @Override
    public void glDrawElementsInstancedBaseVertex(int mode, int count, int type, Buffer indices, int instanceCount, int basevertex) {
        if (indices instanceof ShortBuffer && type == com.badlogic.gdx.graphics.GL32.GL_UNSIGNED_SHORT) {
            ShortBuffer sb = (ShortBuffer)indices;
            int position = sb.position();
            int oldLimit = sb.limit();
            sb.limit(position + count);
            org.lwjgl.opengles.GLES32.glDrawElementsInstancedBaseVertex(mode, sb, instanceCount, basevertex);
            sb.limit(oldLimit);
        } else if (indices instanceof ByteBuffer && type == com.badlogic.gdx.graphics.GL32.GL_UNSIGNED_SHORT) {
            ShortBuffer sb = ((ByteBuffer)indices).asShortBuffer();
            int position = sb.position();
            int oldLimit = sb.limit();
            sb.limit(position + count);
            org.lwjgl.opengles.GLES32.glDrawElementsInstancedBaseVertex(mode, sb, instanceCount, basevertex);
            sb.limit(oldLimit);
        } else if (indices instanceof ByteBuffer && type == com.badlogic.gdx.graphics.GL32.GL_UNSIGNED_BYTE) {
            ByteBuffer bb = (ByteBuffer)indices;
            int position = bb.position();
            int oldLimit = bb.limit();
            bb.limit(position + count);
            org.lwjgl.opengles.GLES32.glDrawElementsInstancedBaseVertex(mode, bb, instanceCount, basevertex);
            bb.limit(oldLimit);
        } else
            throw new GdxRuntimeException(
                    "Can't use " + indices.getClass().getName() + " with this method. Use ShortBuffer or ByteBuffer instead.");
    }

    @Override
    public void glDrawElementsInstancedBaseVertex(int mode, int count, int type, int indicesOffset, int instanceCount, int basevertex) {
        org.lwjgl.opengles.GLES32.glDrawElementsInstancedBaseVertex(mode, count, type, indicesOffset, instanceCount, basevertex);
    }

    @Override
    public void glFramebufferTexture(int target, int attachment, int texture, int level) {
        org.lwjgl.opengles.GLES32.glFramebufferTexture(target, attachment, texture, level);
    }

    @Override
    public int glGetGraphicsResetStatus() {
        return GLES32.glGetGraphicsResetStatus();
    }

    @Override
    public void glReadnPixels(int x, int y, int width, int height, int format, int type, int bufSize, Buffer data) {
        if (data == null) {
            GLES32.glReadnPixels(x, y, width, height, format, type, bufSize, 0L);
        } else {
            int oldLimit = data.limit();
            data.limit(bufSize);
            if (data instanceof ByteBuffer) {
                GLES32.glReadnPixels(x, y, width, height, format, type, (ByteBuffer)data);
            } else if (data instanceof IntBuffer) {
                GLES32.glReadnPixels(x, y, width, height, format, type, (IntBuffer)data);
            } else if (data instanceof ShortBuffer) {
                GLES32.glReadnPixels(x, y, width, height, format, type, (ShortBuffer)data);
            } else if (data instanceof FloatBuffer) {
                GLES32.glReadnPixels(x, y, width, height, format, type, (FloatBuffer)data);
            } else {
                throw new GdxRuntimeException("buffer type not supported");
            }
            data.limit(oldLimit);
        }
    }

    @Override
    public void glGetnUniformfv(int program, int location, FloatBuffer params) {
        GLES32.glGetnUniformfv(program, location, params);
    }

    @Override
    public void glGetnUniformiv(int program, int location, IntBuffer params) {
        // GLES32.glGetnUniformiv(program, location, params);
        // TODO fix later
        throw new GdxRuntimeException("Unimplemented method");
    }

    @Override
    public void glGetnUniformuiv(int program, int location, IntBuffer params) {
        // GLES32.glGetnUniformuiv(program, location, params);
        // TODO fix later
        throw new GdxRuntimeException("Unimplemented method");
    }

    @Override
    public void glMinSampleShading(float value) {
        GLES32.glMinSampleShading(value);
    }

    @Override
    public void glPatchParameteri(int pname, int value) {
        GLES32.glPatchParameteri(pname, value);
    }

    @Override
    public void glTexParameterIiv(int target, int pname, IntBuffer params) {
        GLES32.glTexParameterIiv(target, pname, params);
    }

    @Override
    public void glTexParameterIuiv(int target, int pname, IntBuffer params) {
        GLES32.glTexParameterIuiv(target, pname, params);
    }

    @Override
    public void glGetTexParameterIiv(int target, int pname, IntBuffer params) {
        GLES32.glGetTexParameterIiv(target, pname, params);
    }

    @Override
    public void glGetTexParameterIuiv(int target, int pname, IntBuffer params) {
        GLES32.glGetTexParameterIuiv(target, pname, params);
    }

    @Override
    public void glSamplerParameterIiv(int sampler, int pname, IntBuffer param) {
        GLES32.glSamplerParameterIiv(sampler, pname, param);
    }

    @Override
    public void glSamplerParameterIuiv(int sampler, int pname, IntBuffer param) {
        GLES32.glSamplerParameterIuiv(sampler, pname, param);
    }

    @Override
    public void glGetSamplerParameterIiv(int sampler, int pname, IntBuffer params) {
        GLES32.glGetSamplerParameterIiv(sampler, pname, params);
    }

    @Override
    public void glGetSamplerParameterIuiv(int sampler, int pname, IntBuffer params) {
        GLES32.glGetSamplerParameterIuiv(sampler, pname, params);
    }

    @Override
    public void glTexBuffer(int target, int internalformat, int buffer) {
        GLES32.glTexBuffer(target, internalformat, buffer);
    }

    @Override
    public void glTexBufferRange(int target, int internalformat, int buffer, int offset, int size) {
        GLES32.glTexBufferRange(target, internalformat, buffer, offset, size);
    }

    @Override
    public void glTexStorage3DMultisample(int target, int samples, int internalformat, int width, int height, int depth, boolean fixedsamplelocations) {
        GLES32.glTexStorage3DMultisample(target, samples, internalformat, width, height, depth, fixedsamplelocations);
    }

    @Override
    public void glDispatchCompute(int num_groups_x, int num_groups_y, int num_groups_z) {
        GLES32.glDispatchCompute(num_groups_x, num_groups_y, num_groups_z);
    }

    @Override
    public void glDispatchComputeIndirect(long indirect) {
        GLES32.glDispatchComputeIndirect(indirect);
    }

    @Override
    public void glDrawArraysIndirect(int mode, long indirect) {
        GLES32.glDrawArraysIndirect(mode, indirect);
    }

    @Override
    public void glDrawElementsIndirect(int mode, int type, long indirect) {
        GLES32.glDrawElementsIndirect(mode, type, indirect);
    }

    @Override
    public void glFramebufferParameteri(int target, int pname, int param) {
        GLES32.glFramebufferParameteri(target, pname, param);
    }

    @Override
    public void glGetFramebufferParameteriv(int target, int pname, IntBuffer params) {
        GLES32.glGetFramebufferParameteriv(target, pname, params);
    }

    @Override
    public void glGetProgramInterfaceiv(int program, int programInterface, int pname, IntBuffer params) {
        GLES32.glGetProgramInterfaceiv(program, programInterface, pname, params);
    }

    @Override
    public int glGetProgramResourceIndex(int program, int programInterface, String name) {
        return GLES32.glGetProgramResourceIndex(program, programInterface, name);
    }

    @Override
    public String glGetProgramResourceName(int program, int programInterface, int index) {
        return GLES32.glGetProgramResourceName(program, programInterface, index);
    }

    @Override
    public void glGetProgramResourceiv(int program, int programInterface, int index, IntBuffer props, IntBuffer length, IntBuffer params) {
        GLES32.glGetProgramResourceiv(program, programInterface, index, props, length, params);
    }

    @Override
    public int glGetProgramResourceLocation(int program, int programInterface, String name) {
        return GLES32.glGetProgramResourceLocation(program, programInterface, name);
    }

    @Override
    public void glUseProgramStages(int pipeline, int stages, int program) {
        GLES32.glUseProgramStages(pipeline, stages, program);
    }

    @Override
    public void glActiveShaderProgram(int pipeline, int program) {
        GLES32.glActiveShaderProgram(pipeline, program);
    }

    @Override
    public int glCreateShaderProgramv(int type, String[] strings) {
        return GLES32.glCreateShaderProgramv(type, strings);
    }

    @Override
    public void glBindProgramPipeline(int pipeline) {
        GLES32.glBindProgramPipeline(pipeline);
    }

    @Override
    public void glDeleteProgramPipelines(int count, IntBuffer pipelines) {
        int oldLimit = pipelines.limit();
        pipelines.limit(count);
        GLES32.glDeleteProgramPipelines(pipelines);
        pipelines.limit(oldLimit);
    }

    @Override
    public void glGenProgramPipelines(int count, IntBuffer pipelines) {
        int oldLimit = pipelines.limit();
        pipelines.limit(count);
        GLES32.glGenProgramPipelines(pipelines);
        pipelines.limit(oldLimit);
    }

    @Override
    public boolean glIsProgramPipeline(int pipeline) {
        return GLES32.glIsProgramPipeline(pipeline);
    }

    @Override
    public void glGetProgramPipelineiv(int pipeline, int pname, IntBuffer params) {
        GLES32.glGetProgramPipelineiv(pipeline, pname, params);
    }

    @Override
    public void glProgramUniform1i(int program, int location, int v0) {
        GLES32.glProgramUniform1i(program, location, v0);
    }

    @Override
    public void glProgramUniform2i(int program, int location, int v0, int v1) {
        GLES32.glProgramUniform2i(program, location, v0, v1);
    }

    @Override
    public void glProgramUniform3i(int program, int location, int v0, int v1, int v2) {
        GLES32.glProgramUniform3i(program, location, v0, v1, v2);
    }

    @Override
    public void glProgramUniform4i(int program, int location, int v0, int v1, int v2, int v3) {
        GLES32.glProgramUniform4i(program, location, v0, v1, v2, v3);
    }

    @Override
    public void glProgramUniform1ui(int program, int location, int v0) {
        GLES32.glProgramUniform1ui(program, location, v0);
    }

    @Override
    public void glProgramUniform2ui(int program, int location, int v0, int v1) {
        GLES32.glProgramUniform2ui(program, location, v0, v1);
    }

    @Override
    public void glProgramUniform3ui(int program, int location, int v0, int v1, int v2) {
        GLES32.glProgramUniform3ui(program, location, v0, v1, v2);
    }

    @Override
    public void glProgramUniform4ui(int program, int location, int v0, int v1, int v2, int v3) {
        GLES32.glProgramUniform4ui(program, location, v0, v1, v2, v3);
    }

    @Override
    public void glProgramUniform1f(int program, int location, float v0) {
        GLES32.glProgramUniform1f(program, location, v0);
    }

    @Override
    public void glProgramUniform2f(int program, int location, float v0, float v1) {
        GLES32.glProgramUniform2f(program, location, v0, v1);
    }

    @Override
    public void glProgramUniform3f(int program, int location, float v0, float v1, float v2) {
        GLES32.glProgramUniform3f(program, location, v0, v1, v2);
    }

    @Override
    public void glProgramUniform4f(int program, int location, float v0, float v1, float v2, float v3) {
        GLES32.glProgramUniform4f(program, location, v0, v1, v2, v3);
    }

    @Override
    public void glProgramUniform1iv(int program, int location, IntBuffer value) {
        GLES32.glProgramUniform1iv(program, location, value);
    }

    @Override
    public void glProgramUniform2iv(int program, int location, IntBuffer value) {
        GLES32.glProgramUniform2iv(program, location, value);
    }

    @Override
    public void glProgramUniform3iv(int program, int location, IntBuffer value) {
        GLES32.glProgramUniform3iv(program, location, value);
    }

    @Override
    public void glProgramUniform4iv(int program, int location, IntBuffer value) {
        GLES32.glProgramUniform4iv(program, location, value);
    }

    @Override
    public void glProgramUniform1uiv(int program, int location, IntBuffer value) {
        GLES32.glProgramUniform1uiv(program, location, value);
    }

    @Override
    public void glProgramUniform2uiv(int program, int location, IntBuffer value) {
        GLES32.glProgramUniform2uiv(program, location, value);
    }

    @Override
    public void glProgramUniform3uiv(int program, int location, IntBuffer value) {
        GLES32.glProgramUniform3uiv(program, location, value);
    }

    @Override
    public void glProgramUniform4uiv(int program, int location, IntBuffer value) {
        GLES32.glProgramUniform4uiv(program, location, value);
    }

    @Override
    public void glProgramUniform1fv(int program, int location, FloatBuffer value) {
        GLES32.glProgramUniform1fv(program, location, value);
    }

    @Override
    public void glProgramUniform2fv(int program, int location, FloatBuffer value) {
        GLES32.glProgramUniform2fv(program, location, value);
    }

    @Override
    public void glProgramUniform3fv(int program, int location, FloatBuffer value) {
        GLES32.glProgramUniform3fv(program, location, value);
    }

    @Override
    public void glProgramUniform4fv(int program, int location, FloatBuffer value) {
        GLES32.glProgramUniform4fv(program, location, value);
    }

    @Override
    public void glProgramUniformMatrix2fv(int program, int location, boolean transpose, FloatBuffer value) {
        GLES32.glProgramUniformMatrix2fv(program, location, transpose, value);
    }

    @Override
    public void glProgramUniformMatrix3fv(int program, int location, boolean transpose, FloatBuffer value) {
        GLES32.glProgramUniformMatrix3fv(program, location, transpose, value);
    }

    @Override
    public void glProgramUniformMatrix4fv(int program, int location, boolean transpose, FloatBuffer value) {
        GLES32.glProgramUniformMatrix4fv(program, location, transpose, value);
    }

    @Override
    public void glProgramUniformMatrix2x3fv(int program, int location, boolean transpose, FloatBuffer value) {
        GLES32.glProgramUniformMatrix2x3fv(program, location, transpose, value);
    }

    @Override
    public void glProgramUniformMatrix3x2fv(int program, int location, boolean transpose, FloatBuffer value) {
        GLES32.glProgramUniformMatrix3x2fv(program, location, transpose, value);
    }

    @Override
    public void glProgramUniformMatrix2x4fv(int program, int location, boolean transpose, FloatBuffer value) {
        GLES32.glProgramUniformMatrix2x4fv(program, location, transpose, value);
    }

    @Override
    public void glProgramUniformMatrix4x2fv(int program, int location, boolean transpose, FloatBuffer value) {
        GLES32.glProgramUniformMatrix4x2fv(program, location, transpose, value);
    }

    @Override
    public void glProgramUniformMatrix3x4fv(int program, int location, boolean transpose, FloatBuffer value) {
        GLES32.glProgramUniformMatrix3x4fv(program, location, transpose, value);
    }

    @Override
    public void glProgramUniformMatrix4x3fv(int program, int location, boolean transpose, FloatBuffer value) {
        GLES32.glProgramUniformMatrix4x3fv(program, location, transpose, value);
    }

    @Override
    public void glValidateProgramPipeline(int pipeline) {
        GLES32.glValidateProgramPipeline(pipeline);
    }

    @Override
    public String glGetProgramPipelineInfoLog(int program) {
        return GLES32.glGetProgramPipelineInfoLog(program);
    }

    @Override
    public void glBindImageTexture(int unit, int texture, int level, boolean layered, int layer, int access, int format) {
        GLES32.glBindImageTexture(unit, texture, level, layered, layer, access, format);
    }

    @Override
    public void glGetBooleani_v(int target, int index, IntBuffer data) {
        GLES32.glGetBooleani_v(target, index, tmpByteBuffer);
        data.put(tmpByteBuffer.asIntBuffer());
    }

    @Override
    public void glMemoryBarrier(int barriers) {
        GLES32.glMemoryBarrier(barriers);
    }

    @Override
    public void glMemoryBarrierByRegion(int barriers) {
        GLES32.glMemoryBarrierByRegion(barriers);
    }

    @Override
    public void glTexStorage2DMultisample(int target, int samples, int internalformat, int width, int height, boolean fixedsamplelocations) {
        GLES32.glTexStorage2DMultisample(target, samples, internalformat, width, height, fixedsamplelocations);
    }

    @Override
    public void glGetMultisamplefv(int pname, int index, FloatBuffer val) {
        GLES32.glGetMultisamplefv(pname, index, val);
    }

    @Override
    public void glSampleMaski(int maskNumber, int mask) {
        GLES32.glSampleMaski(maskNumber, mask);
    }

    @Override
    public void glGetTexLevelParameteriv(int target, int level, int pname, IntBuffer params) {
        GLES32.glGetTexLevelParameteriv(target, level, pname, params);
    }

    @Override
    public void glGetTexLevelParameterfv(int target, int level, int pname, FloatBuffer params) {
        GLES32.glGetTexLevelParameterfv(target, level, pname, params);
    }

    @Override
    public void glBindVertexBuffer(int bindingindex, int buffer, long offset, int stride) {
        GLES32.glBindVertexBuffer(bindingindex, buffer, offset, stride);
    }

    @Override
    public void glVertexAttribFormat(int attribindex, int size, int type, boolean normalized, int relativeoffset) {
        GLES32.glVertexAttribFormat(attribindex, size, type, normalized, relativeoffset);
    }

    @Override
    public void glVertexAttribIFormat(int attribindex, int size, int type, int relativeoffset) {
        GLES32.glVertexAttribIFormat(attribindex, size, type, relativeoffset);
    }

    @Override
    public void glVertexAttribBinding(int attribindex, int bindingindex) {
        GLES32.glVertexAttribBinding(attribindex, bindingindex);
    }

    @Override
    public void glVertexBindingDivisor(int bindingindex, int divisor) {
        GLES32.glVertexBindingDivisor(bindingindex, divisor);
    }
}
